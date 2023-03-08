package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesDescontos {
	
	/**
	 * Pattern Chain of Responsability:
	 * 
	 * Parecido com o Strategy, mas sabemos qual validacao devemos fazer. Num cenário
	 * onde não sabemos em qual regra vai entrar, podemos utilizar o Chain of Responsability.
	 * 
	 * Criamos uma classe abstrata que dever conter os contratos necessarios e depois criamos
	 * as classes concretas que vão herdar da classe mãe abstrata e que devem validar a regra
	 * e caso não consigam, elas devem chamar a proxima classe concreta que tb irá validar a regra.
	 * Aqui no caso temos duas classes concretas que fazem uma validacao para ver se vai entrar 
	 * na regra e criamos tb uma classe chamada "SemDesconto" que tb herda da classe mãe, porém
	 * apenas com a finalidade de encerrar o fluxo de validacao.
	 * 
	 * Pense no fluxo de abertura de chamados de uma assistencia. Quando você abre um chamado,
	 * o primeiro atendimento é um robo, se ele não resolver ele vai delegar para o suporte n1,
	 * se este tb não resolver, ele irá delegar para o suporte n2, se este tb não resolver, ele
	 * irá delegar para n3 e etc. É exatamente essa a ideia do Chain of Responsability.
	 * 
	 */

	/**
	 * Pattern Template Method:
	 * 
	 * A ideia desse pattern, é ter um metodo como se fosse um template, um padrão, um modelo que
	 * faz parte do processo, mas ele delega.
	 * 
	 * Veja que tiramos a logica das classes filhas de Desconto, e deixamos a regra no metodo
	 * "calcular" na classe mãe Desconto. Com isso, caso tenhamos que criar um novo tipo de Desconto,
	 * basta ele herdar da classe mãe e implementar os metodos abstratos.
	 * Essa mudança nos favore em tirar o código repetido, principalmente das classes filhas de Desconto.
	 * 
	 */
	
	public static void main(String[] args) {

		Orcamento orcamentoPrimeiro = new Orcamento();
		orcamentoPrimeiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		
		Orcamento orcamentoSegundo = new Orcamento();
		orcamentoSegundo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		
		Orcamento orcamentoTerceiro = new Orcamento();
		orcamentoTerceiro.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(orcamentoPrimeiro));
		System.out.println(calculadora.calcular(orcamentoSegundo));
		System.out.println(calculadora.calcular(orcamentoTerceiro));
	}

}
