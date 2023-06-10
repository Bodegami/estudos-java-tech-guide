package br.com.bodefood.pagamentos.service;

import br.com.bodefood.pagamentos.dto.PagamentoDto;
import br.com.bodefood.pagamentos.model.Pagamento;
import br.com.bodefood.pagamentos.repository.PagamentoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    private PagamentoRepository repository;
    private ObjectMapper mapper;


    public PagamentoService(PagamentoRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(PagamentoDto::new);
    }

    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Pagamento não encontrado!"));

        return new PagamentoDto(pagamento);
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
}
