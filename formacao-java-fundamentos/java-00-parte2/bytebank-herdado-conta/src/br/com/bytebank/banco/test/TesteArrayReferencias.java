package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {

		//Conta[] contas = new Conta [5];
		Object[] referencias = new Object [5];
		
		//o valor padrao de referencias é null
		for (int i = 0; i < referencias.length; i++) {
			System.out.println(referencias[i]);
		}
		
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		referencias[0] = cc1;
		System.out.println(referencias[0]);
		
		ContaPoupanca cc2 = new ContaPoupanca(22, 11);
		referencias[1] = cc2;
		
		//System.out.println(cc2.getNumero());
		
		//Object referenciaGenerica = contas[1];
		// Não funciona, pois o compilador sabe que não existe o metodo getNumero() na classe Object
		//System.out.println(referenciaGenerica.getNumero()); 
		
		// Conta ref = contas[1]; -> o compilador ñ consegue verificar o tipo correto, por isso ele aponta 
		//para o tipo mais generico
		ContaPoupanca ref = (ContaPoupanca) referencias[1]; //type cast
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());
		
		//ContaCorrente ref = (ContaCorrente) contas[1]; -> retorna a excecao ClassCastException
		System.out.println(ref);
		
		Cliente cliente = new Cliente();
		referencias[2] = cliente;
		System.out.println(referencias[2]);
		
	}

}
