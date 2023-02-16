package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	
	//Pattern utilizado Strategy
	
	//O TDD é interessante de se aplicar quando temos cenarios que ainda não estão muito
	//claros em como vai ficar o codigo, quantas classes vou precisar e etc

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentual = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
	}

}
