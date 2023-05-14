package br.com.alura.cliente.exemplos;

import java.util.Arrays;
import java.util.List;

public class ExecutaTarefa {

	public static void main(String[] args) {


		//Primeira forma:
		
		//no método main, para inicializar a tarefa
//		Runnable tarefa = new Tarefa();
//		new Thread(tarefa).start();
		
		
		//Segunda forma:
		
		//criando uma classe anonima e passando no construtor da Thread
//		new Thread(new Runnable() {
//
//		    public void run() {
//		        System.out.println("rodando");
//		    }
//		}).start();

		
		//Terceira forma:
		//usamos uma expressao lambda e dentro do bloco passamos o comando a ser executado
		new Thread( () -> { 
			List<String> nomes = Arrays.asList("Flavio", "Nico", "Romulo"); //criando lista
			nomes.forEach(nome -> System.out.println(nome)); //usando lambdas
			
			})
		.start();
		
	}

}
