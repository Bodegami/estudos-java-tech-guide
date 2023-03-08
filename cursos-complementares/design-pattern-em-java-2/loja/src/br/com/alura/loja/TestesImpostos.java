package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesImpostos {

	/**
	 * Pattern Decorator:
	 * 
	 * A ideia do Decorator é decorar/compor um objeto com outro objeto.
	 * Fazendo um analogia com a arvore de natal, pense que você comprou
	 * uma arvore de natal, tirou da caixa e montou na sua casa. Pronto, 
	 * você tem uma arvore de natal. Depois você decora ela com pisca-piscas,
	 * agora você tem uma arvore de natal com pisca-piscas. Depois você coloca
	 * uma estrela no topo. Você tem um arvore de natal com pisca-piscas e 
	 * estrela no topo. Note que conforme a necessidade, você vai decorando seu 
	 * objeto com outros e alterando o seu comportamento.
	 * 
	 * Essa é a ideia do Decorator, você ter uma classe que possa ser decorada
	 * com outros objetos ou não e mudando o seu comportamento de acordo com
	 * o objeto.
	 * 
	 * No exemplo abaixo, passamos "null" quando queremos chamar um objeto sem
	 * usar o decorator. Por exemplo, eu passo o imposto do ISS, que recebe um
	 * objeto ICMS, mas o objeto ICMS não recebe outro imposto e encerra o 
	 * encadeiamento ali.
	 * 
	 */
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
		

	}

}
