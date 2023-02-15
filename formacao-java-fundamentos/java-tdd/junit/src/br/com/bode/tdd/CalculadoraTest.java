package br.com.bode.tdd;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	
	@Test
	public void deveriaSomarDoisNumerosPositivos() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 7);
		
		int expectedResult = 10;
		
		Assert.assertEquals(expectedResult, soma);
	}

}
