package br.com.alura.rh.tributacao;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste {
	
	BigDecimal valorImpostoDeRenda();

}
