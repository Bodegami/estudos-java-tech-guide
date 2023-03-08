package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoes;
	
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(geraPedido.getValorOrcamento()));
		
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(acao -> acao.executarAcao(pedido));
	}
	
}
