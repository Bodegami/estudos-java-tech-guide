package br.com.bytebank.banco.test;

public class TesteArrayString {

	public static void main(String[] args) {
		
		/**
		 * TESTANDO VIA CLI:
		 * 
		 * 1 - abrir o terminal
		 * 2 - navegar ate a raiz do projeto
		 * 3 - acessar o diretorio: bin
		 * 4 - usar o comando java com o FQN da classe e passando as strings como argumentos
		 * 5 - EX: java br.com.bytebank.banco.test.TestArrayString oi um dois java
		 * 
		 * 
		 * TESTANDO VIA ECLIPSE:
		 * 
		 * 1 - Na classe que deseja testar, ir em "Run Configurations"
		 * 2 - Na janela que abriu, selecionar a classe do lado esquerdo e ir no aba "Arguments"
		 * 3 - No campo "program arguments" passar o argumentos que serão inseridos junto ao comando run
		 * 
		 */
		
		System.out.println("Funcionou!!");
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
	}
	
}
