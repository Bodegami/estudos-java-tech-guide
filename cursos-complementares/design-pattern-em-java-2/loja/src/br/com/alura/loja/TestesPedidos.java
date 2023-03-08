package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestesPedidos {
	
	/**
	 * Pattern FACADE:
	 * 
	 * A ideia dele é ter uma fachada. Basicamente, quando temos
	 * um processo complexo, que envolve varias etapas, varias
	 * classes, varias chamadas de metodos, ao inves de expormos
	 * essa complexidade para o cliente e ele ter que saber quais 
	 * objetos tem que chamar, a ordem e tudos mais, ele simplesmente
	 * chama uma fachada, chama um metodo que faz o encapsulamento de 
	 * toda essa complexidade.
	 * Assim livramos o cliente de ter que saber toda a complexidade
	 * da execucao, além de ficamos livres para alterar a implementacao
	 * com menos risco de prejudicar um cliente que utiliza essa classe.
	 * 
	 * Simplesmente, abstraimos e encapsulamos toda complexidade e 
	 * disponibilizamos uma interface, um metodo que para o cliente.
	 * 
	 * 
	 * Aqui, aplicamos esse pattern no metodo executa do Handler.
	 * Note que dentro do metodo ele executa diversas chamadas e tudo
	 * mais, mas para o cliente disponibilizamos apenas um metodo que
	 * faz o encapsulamento de toda essa complexidade.
	 * 
	 */
	
	public static void main(String[] args) {
		
		String cliente = args[0];
		BigDecimal valorOrcamento = new BigDecimal(args[1]);
		int quantidadeItens = Integer.parseInt(args[2]);
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
								new SalvarPedidoNoBancoDeDados(),
								new EnviarEmailPedido(),
								new LogDePedido()
								));
		handler.executa(gerador);
	}

}
