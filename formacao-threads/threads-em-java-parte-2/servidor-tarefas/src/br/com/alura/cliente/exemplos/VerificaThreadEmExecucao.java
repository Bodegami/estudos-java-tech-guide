package br.com.alura.cliente.exemplos;

import java.util.Set;

public class VerificaThreadEmExecucao {

	public static void main(String[] args) {


		Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();

		for (Thread thread : todasAsThreads) {
		    System.out.println(thread.getName());
		}

	    Runtime runtime = Runtime.getRuntime();
	    int qtdProcessadores = runtime.availableProcessors();
	    System.out.println("Qtd de processadores: " + qtdProcessadores);
	}

}
