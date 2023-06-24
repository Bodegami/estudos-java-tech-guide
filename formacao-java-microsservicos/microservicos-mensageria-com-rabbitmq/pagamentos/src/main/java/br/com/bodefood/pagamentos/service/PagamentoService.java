package br.com.bodefood.pagamentos.service;

import br.com.bodefood.pagamentos.dto.PagamentoDto;
import br.com.bodefood.pagamentos.http.PedidoClient;
import br.com.bodefood.pagamentos.model.Pagamento;
import br.com.bodefood.pagamentos.model.Status;
import br.com.bodefood.pagamentos.repository.PagamentoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PagamentoService {

    private PagamentoRepository repository;
    private ObjectMapper mapper;

    private PedidoClient client;

    public PagamentoService(PagamentoRepository repository, ObjectMapper mapper, PedidoClient client) {
        this.repository = repository;
        this.mapper = mapper;
        this.client = client;
    }


    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(PagamentoDto::new);
    }

    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado!"));

        PagamentoDto dto = new PagamentoDto(pagamento);
        dto.setItens(client.obterItensDoPedido(pagamento.getPedidoId()).getItens());
        return dto;
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        Pagamento pagamento = new Pagamento();
        BeanUtils.copyProperties(dto, pagamento);
        repository.save(pagamento);

        return new PagamentoDto(pagamento);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = new Pagamento();
        BeanUtils.copyProperties(dto, pagamento);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);

        return new PagamentoDto(pagamento);
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }

    public void confirmarPagamento(Long id){
        Pagamento pagamento = persistePagamentoNoDB(id, Status.CONFIRMADO);
        client.atualizaPagamento(pagamento.getPedidoId());
    }

    public void alteraStatus(Long id) {
        persistePagamentoNoDB(id, Status.CONFIRMADO_SEM_INTEGRACAO);
    }

    private Pagamento persistePagamentoNoDB(Long id, Status status) {
        Optional<Pagamento> pagamento = repository.findById(id);

        if (!pagamento.isPresent()) {
            throw new EntityNotFoundException();
        }

        pagamento.get().setStatus(status);
        return repository.save(pagamento.get());
    }
}
