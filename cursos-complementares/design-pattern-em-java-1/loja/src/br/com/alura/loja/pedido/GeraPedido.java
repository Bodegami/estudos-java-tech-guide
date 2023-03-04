package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {

	private String cliente;
	private BigDecimal valorOrcamento;
	private int quantidadeItens;

	// Injecao de dependencias: PedidoRepository, EmailService e etc...
	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeItens = quantidadeItens;
	}

//	public void executa() {
//		Orcamento orcamento = new Orcamento(this.valorOrcamento, this.quantidadeItens);
//		
//		Pedido pedido = new Pedido(cliente, LocalDateTime.now(), orcamento);
//
//		System.out.println("Salvar pedido no Banco de Dados");
//		System.out.println("Enviar email com dados do novo pedido");
//	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

}
