package br.com.alura.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteBiblioteca {
	
	/*
	 * IMPORTANDO UMA LIB:
	 * 1 - criar um diretorio chamado 'lib'
	 * 2 - copiar o .jar para dentro do diretorio 'lib'
	 * 3 - adicionar o .jar ao buildpath
	 * 4 - pronto!
	 * 
	 */

	public static void main(String[] args) {
		
		Conta c = new ContaCorrente(123, 321);
		
		c.deposita(200.3);
		
		System.out.println(c.getSaldo());

	}

}
