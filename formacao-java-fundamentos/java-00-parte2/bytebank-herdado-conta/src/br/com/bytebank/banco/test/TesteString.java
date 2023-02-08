package br.com.bytebank.banco.test;

public class TesteString {

	public static void main(String[] args) {
		
		// A String é imutavel, por isso, qualquer metodo da classe String devolve uma String
		
		int a = 3;
		String nome = "Alura"; //object literal
		//String outro = new String("Alura"); -> má pratica
		
		//nome.replace("A", "a"); -> não funciona pq a String é imutavel
		//nome.toLowerCase(); -> não funciona pq a String é imutavel
		
		String outra = nome.replace("A", "a");
		String outra2 = nome.toLowerCase();
		
		System.out.println(nome);
		System.out.println(outra);
		System.out.println(outra2);
		

	}

}
