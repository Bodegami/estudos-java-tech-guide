package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesComposicao {
	
	/**
	 * 
	 * Pattern COMPOSITE:
	 * 
	 * É a ideia de você compor um objeto com outro.
	 * É parecido com o Decorator, mas no decorator nos
	 * decoramos um objeto com outro, seguindo um encadeamento
	 * de objetos e no final comportamento é alterado conforme
	 * os objetos que foram decorando.
	 * Já no composite é quando temos a ideia de compor objetos,
	 * porem existe uma hierarquia de objetos a serem compostos.
	 * 
	 * No Decorator temos um objeto componando o proximo e mudando 
	 * o comportamento no final. No composite temos um objeto 
	 * compondo o outro, ou seja, temos uma herarquia de objetos.
	 * 
	 * 	 
	 */

	public static void main(String[] args) {
		
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		antigo.reprovar();
		
		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);
		
		System.out.println(novo.getValor());
		System.out.println(novo.getValor());
		
	}
	
}
