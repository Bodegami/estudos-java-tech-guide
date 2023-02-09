package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeReferencias;

public class TesteGuardadorDeReferencias {

	public static void main(String[] args) {
		
		GuardadorDeReferencias guardador = new GuardadorDeReferencias();
		
		Conta cc = new ContaCorrente(22, 11);
		guardador.adiciona(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		guardador.adiciona(cc2);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Renato");
		guardador.adiciona(cliente);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Object ref = guardador.getReferencia(0);
		Conta ref1 = (ContaCorrente) guardador.getReferencia(1);
		Cliente ref2 = (Cliente) guardador.getReferencia(2);
		
		System.out.println(ref);
		System.out.println(ref1);
		System.out.println(ref2.getNome());
	}
	
}
