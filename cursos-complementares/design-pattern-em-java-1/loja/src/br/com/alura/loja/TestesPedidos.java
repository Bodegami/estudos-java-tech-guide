package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

public class TestesPedidos {
	
	/**
	 * Pattern COMMAND:
	 * 
	 * É um pattern que representa a execucao de um comando que precisa ser executado.
	 * Na verdade utilizamos esse padrao quanto temos varias classes que contem um método
	 * em comum, como o metodo executa da classe GeraPedido e essa classe implementaria
	 * uma interface com a mesma assinatura. Então todas as classes com a mesma assinatura
	 * de metodo implementariam essa interface.
	 * Note que no padrão COMMAND, a classe além de ter o método executa, ela tem também
	 * os dados e as dependencias necessárias para execução.
	 * 
	 * 
	 * 
	 * Pattern COMMAND HANDLER:
	 * 
	 * É uma variação do Pattern COMMAND, porém no COMMAND HANDLER os dados são separados
	 * da classe que implementa o metodo executa.
	 * Aqui no projeto a classe GeraPedidos é responsavel pelos dados, enquanto a classe 
	 * GeraPedidoHandler implementa o metodo executa.
	 * Veja que criamos um objeto do tipo GeraPedido contendo os dados de entrada e depois
	 * criamos um objeto do tipo GeraPedidoHandler, chamando o metodo executa passando o
	 * objeto do tipo GeraPedido como parametro.
	 * 
	 */
	
	public static void main(String[] args) {
		
		String cliente = args[0];
		BigDecimal valorOrcamento = new BigDecimal(args[1]);
		int quantidadeItens = Integer.parseInt(args[2]);
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(/*dependencias*/);
		handler.executa(gerador);
	}

}
