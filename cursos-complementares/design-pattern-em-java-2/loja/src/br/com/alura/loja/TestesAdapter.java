package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

public class TestesAdapter {
	
	/**
	 * Pattern Adapter:
	 * 
	 * Tem como premissa fazer uma adaptação.
	 * Temos uma classe, que no nosso caso é RegistroDeOrcamento e ela
	 * precisa conversar com outra classe, no caso o protocolo HTTP e que
	 * existem varias maneiras distintas de conversar com essa outra classe,
	 * e nos não queremos ficar presos a uma dessas maneiras e não queremos 
	 * implementar esses detalhes de infraestrutura.
	 * Então criamos uma classe que vai ficar no meio, ou seja, fazer essa
	 * adaptacao, essa ponte entre a nossa classe e o mundo externo é essa 
	 * classe vai funcionar como um adaptador, além disso utilizando
	 * interface e polimorfismo como fizemos, deixamos o nosso codigo bem
	 * flexivel, o que nos permite trocar de adaptadores sem tantas dores.
	 * 
	 * Pense nesse pattern como um adaptador de tomada, onde dependendo da 
	 * tomada so trocamos o adaptador, não precisamos trocar o cabo ou o
	 * "codigo".
	 * 
	 */
	
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
		registro.registrar(orcamento);
	}

}
