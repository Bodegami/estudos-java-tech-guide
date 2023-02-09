package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayReferencias {

	public static void main(String[] args) {

		ContaCorrente[] contas = new ContaCorrente[5];
		
		//o valor padrao de referencias é null
		for (int i = 0; i < contas.length; i++) {
			System.out.println(contas[i]);
		}
		
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		contas[0] = cc1;
		System.out.println(contas[0]);
		
		ContaCorrente cc2 = new ContaCorrente(22, 11);
		contas[1] = cc2;
		
		//System.out.println(cc2.getNumero());
		System.out.println(contas[1].getNumero());
		
		ContaCorrente ref = contas[1];
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());
		
	}

}
