package br.com.alura.rh.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel {

	private BigDecimal valor;
	private LocalDate data;

	public Promocao(BigDecimal valor, LocalDate data) {
		this.valor = valor;
		this.data = data;
	}

	@Override
	public BigDecimal valor() {
		return valor;
	}

	@Override
	public LocalDate data() {
		return data;
	}
	
	//O imposto é 10% do valor
	@Override
	public BigDecimal valorImpostoDeRenda() {
		return valor.multiply(new BigDecimal("0.1"));
	}

}
