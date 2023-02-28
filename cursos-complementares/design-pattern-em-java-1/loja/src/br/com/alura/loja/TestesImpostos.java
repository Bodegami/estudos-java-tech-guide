package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;

public class TestesImpostos {

	/**
	 * Pattern Strategy:
	 * 
	 * Ao inves de criar um switch ou if que faz determinada coisa dependendo da
	 * informacao que receber, podemos usar o Strategy que nos permite criar uma
	 * interface ou classe abstrata que detem um contrato, e apartir disso criamos
	 * classes concretas para que implementem esse contrato. Dessa forma temos um
	 * código mais coeso e com classes que tendem a mudar pouco.
	 * 
	 */
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(new BigDecimal("100"));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		System.out.println(calculadora.calcular(orcamento, new ICMS()));
		System.out.println(calculadora.calcular(orcamento, new ISS()));
		

	}

}
