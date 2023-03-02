package br.com.alura.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	
	/**
	 * Pattern State:
	 * 
	 * É bem parecido com o Strategy, porém ele representa o justamente a questão de estado.
	 * Esse padrão é utilizado quando temos um transição de estados ou quando a gente precisa
	 * aplicar um regra ou algoritmo, baseado num estado de um objeto ou uma classe.
	 * 
	 * Com isso eliminamos if's e else's e conseguimos aplicar regras mais bem definidas para
	 * cada tipo de transicao de estado.
	 * 
	 * 
	 */
	
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Orcamento nao pode ser aprovado!");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Orcamento nao pode ser reprovado!");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Orcamento nao pode ser finalizado!");
	}

}
