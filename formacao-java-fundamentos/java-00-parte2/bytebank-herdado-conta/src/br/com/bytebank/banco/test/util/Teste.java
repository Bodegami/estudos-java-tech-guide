package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class Teste {

	public static void main(String[] args) {
		
		ArrayList lista = new ArrayList();
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		Object ref = (Conta) lista.get(0);
		System.out.println(ref);
		
		lista.remove(0);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta cc3 = new ContaCorrente(33, 311);
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(44, 422);
		lista.add(cc4);
		
		//Old form
//		for (int i = 0; i <lista.size(); i++) {
//			System.out.println(lista.get(i));
//		}
		
		for (Object obj : lista) {
			System.out.println(obj);
		}
		
	}
	
}
