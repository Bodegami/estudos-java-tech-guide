package br.com.bytebank.banco.test;

public class TesteString {

	public static void main(String[] args) {
		
		// A String é imutavel, por isso, qualquer metodo da classe String devolve uma String
		
		String nome = "Alura"; //object literal
		//String outro = new String("Alura"); -> má pratica
		
		//nome.replace("A", "a"); -> não funciona pq a String é imutavel
		//nome.toLowerCase(); -> não funciona pq a String é imutavel
		
		String nomeReplaceCharSequence = nome.replace("Al", "al");
		String nomeReplaceChar = nome.replace('A', 'a');
		String nomeLowerCase = nome.toLowerCase();
		String nomeUpperCase = nome.toUpperCase(); 
		
		char nomeCharAt = nome.charAt(2);
		int nomeIndexOf = nome.indexOf("ur");
		String nomeSubstring = nome.substring(1);
		int nomeLength = nome.length();
		
		for (int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
		String vazio = " ";
		boolean stringVazio = vazio.isEmpty();
		
		String stringSemEspaco = vazio.trim();
		boolean stringVazioSemEspaco = stringSemEspaco.isEmpty();
		
		boolean nomeContains = nome.contains("Alu");
		
		
		
		System.out.println("nome: " + nome);
		System.out.println("nomeReplaceCharSequence: " + nomeReplaceCharSequence);
		System.out.println("nomeReplaceChar: " + nomeReplaceChar);
		System.out.println("nomeLowerCase: " + nomeLowerCase);
		System.out.println("nomeUpperCase: " + nomeUpperCase);
		System.out.println("nomeCharAt: " + nomeCharAt);
		System.out.println("nomeIndexOf: " + nomeIndexOf);
		System.out.println("nomeSubstring: " + nomeSubstring);
		System.out.println("nomeLength: " + nomeLength);
		System.out.println("stringVazio: " + stringVazio);
		System.out.println("stringVazioSemEspaco: " + stringVazioSemEspaco);
		System.out.println("nomeContains: " + nomeContains);
		
		
		/**
		 *  ANALISANDO O System.out.println("alura"):
		 * 
		 * 
		 * System:
		 *   - classe, java.lang, acesso public
		 * out:
		 *   - atributo, public, referencia a objeto, static
		 * println()
		 *   - metodo, public, nao static, sobrecarga, nao joga excecoes do tipo checked 
		 * 
		 */
		
	}

}
