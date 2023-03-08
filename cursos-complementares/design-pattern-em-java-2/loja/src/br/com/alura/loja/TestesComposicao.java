package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.OrcamentoProxy;

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
	 * Pattern PROXY:
	 * 
	 * É a ideia do proxy de redes. Nos temos um objeto e criamos 
	 * um proxy que vai criar uma camada que vai ficar interceptando
	 * as chamadas ao meu objeto original e com isso conseguimos
	 * fazer validações, otimizações, verificações e enfim, não so
	 * para performance, mas em qualquer situação que precisamos 
	 * interceptar um objeto para fazer algum tratamento e você
	 * quer talvez armazenar isso numa informacao, então podemos
	 * usar um objeto proxy.
	 * 
	 * A propria JPA trabalha com esse conceito. Quando fazemos um select
	 * no banco de alguma classe que tem relacionamento, a JPA devolve
	 * somente o objeto da chamada, para devolver os dados do relacionamento
	 * seria necessario fazer um get nesse dado, ou seja, o hibernate devolve 
	 * um proxy desse relacionamento.
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
		
		OrcamentoProxy proxy = new OrcamentoProxy(novo);
		
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		
	}
	
}
