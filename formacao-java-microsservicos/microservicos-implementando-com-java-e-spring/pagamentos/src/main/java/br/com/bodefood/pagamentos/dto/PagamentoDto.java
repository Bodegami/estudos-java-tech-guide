package br.com.bodefood.pagamentos.dto;

import br.com.bodefood.pagamentos.model.Pagamento;
import br.com.bodefood.pagamentos.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PagamentoDto {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId;

    public PagamentoDto(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.valor = pagamento.getValor();
        this.nome = pagamento.getNome();
        this.numero = pagamento.getNumero();
        this.expiracao = pagamento.getExpiracao();
        this.codigo = pagamento.getCodigo();
        this.status = pagamento.getStatus();
        this.pedidoId = pagamento.getPedidoId();
        this.formaDePagamentoId = pagamento.getFormaDePagamentoId();
    }
}
