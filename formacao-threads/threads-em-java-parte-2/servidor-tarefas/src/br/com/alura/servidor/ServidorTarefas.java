package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
	/**
	 * O AtomicBoolean é uma alternativa criada ao "volatile" que
	 * nao foi bem recebido pela comunidade.
	 */
	
	private ExecutorService threadPool;
	private ServerSocket servidor;
	private AtomicBoolean estaRodando;

	public ServidorTarefas() throws IOException {
		System.out.println("---- Iniciando o servidor -----");
		this.servidor = new ServerSocket(12345);
		this.threadPool = Executors.newCachedThreadPool();
		this.estaRodando = new AtomicBoolean(true);
	}

	public void rodar() throws IOException {
		while (this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();		
				System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket, this);
				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("SocketException, está rodando? " + this.estaRodando);
			}
		}
		
	}
	
	public void parar() throws IOException {
		this.estaRodando.set(false);;
		servidor.close();
		threadPool.shutdown();
//		System.exit(0);
	}
	
	public static void main(String[] args) throws Exception {
		
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.parar();
	}
	

	//Estabelencendo um numero fixo de Threads
	//ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	//Estabelencendo um numero fixo de threads com schedule para execucao
	//ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
	//pool.scheduleAtFixedRate(distribuirTarefas, 0, 60, TimeUnit.MINUTES); //executamos uma tarefa a cada 60 minutos

}
