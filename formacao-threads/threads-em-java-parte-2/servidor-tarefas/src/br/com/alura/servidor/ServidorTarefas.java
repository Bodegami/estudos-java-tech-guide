package br.com.alura.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServidorTarefas {
	public static void main(String[] args) throws Exception {
	
		
		System.out.println("---- Iniciando o servidor -----");
		ServerSocket servidor = new ServerSocket(12345);
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		while (true) {
			Socket socket = servidor.accept();		
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			
			threadPool.execute(distribuirTarefas);
		}
		
	}
	
	
	
	
	
	
	
	//Estabelencendo um numero fixo de Threads
	//ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	//Estabelencendo um numero fixo de threads com schedule para execucao
	//ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
	//pool.scheduleAtFixedRate(distribuirTarefas, 0, 60, TimeUnit.MINUTES); //executamos uma tarefa a cada 60 minutos

}
