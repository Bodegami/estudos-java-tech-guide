package br.com.bytebank.banco.test.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		
		/**
		 * ArrayList é muito bom para iterar sobre os elementos através de um laço,
		 * porém ele não é tão performatico para fazer remoção de elementos da lista.
		 * 
		 * LinkedList tem como caracteristicas adicionar os elementos na ordem que forem
		 * sendo inseridos e cada elementos guarda um "ponteiro" para o elemento anterior
		 * e o posterior, caso tenha.
		 * Isso torna ele muito performatico para operações que exigem remover um elemento
		 * da lista. 
		 * 
		 * List é a interface que detem os contratos que tanto o ArrayList, quanto o 
		 * LinkedList implementam.
		 * 
		 */
		
		//Generics -> utilizamos para tipificar o tipo (Conta) do arrayList
		//ArrayList<Conta> lista = new ArrayList<Conta>();
		
		//List<Conta> lista = new LinkedList<Conta>();
		List<Conta> lista = new Vector<Conta>(); //thread safe
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta ref = lista.get(0);
		System.out.println(ref);
		
		lista.remove(0);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta cc3 = new ContaCorrente(33, 311);
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(44, 422);
		lista.add(cc4);
		
		//Old form
		for (int i = 0; i <lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		
		System.out.println("-----------------------------");
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
	}
	
}
