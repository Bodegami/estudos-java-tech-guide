package br.com.alura.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TesteFila {
	
	public static void main(String[] args) throws InterruptedException {
		
		// implementacao para fila concorrente
		BlockingQueue<String> fila = new ArrayBlockingQueue<>(3);
		
		//funciona como add, porem ele oferece o elemento para fila que devolve um booleano se aceita ou nao o elemento
//		fila.offer("c1"); 
//		fila.offer("c2");
//		fila.offer("c3");

//		System.out.println(fila.peek()); //o peek pega o primeiro elemento da fila, mas mantem o elemento na fila
//		System.out.println(fila.poll()); //o poll pega o primeiro elemento da fila e remove o mesmo da fila
//		System.out.println(fila.poll());
		
		//adiciona o elemento na fila, porem quando a fila chega o seu limite, 
		//ele aguarda liberar espaco na fila para inserir o proximo elemento
		fila.put("c1");
		fila.put("c2");
		fila.put("c3");
		//fila.put("c4"); 
		
		System.out.println(fila.take()); 
		System.out.println(fila.take()); 
		System.out.println(fila.take());
		//System.out.println(fila.take());
		
		System.out.println(fila.size());
		
	}

}
