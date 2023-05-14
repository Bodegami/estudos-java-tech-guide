package br.com.alura.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	
	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("conexao estabelicida");
		
		Thread threadEnviaComando = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					System.out.println("Pode enviar comandos:");
					PrintStream saida = new PrintStream(socket.getOutputStream());		
					Scanner teclado = new Scanner(System.in);
					
					while (teclado.hasNextLine()) {
						String linha = teclado.nextLine();
						
						if (linha.trim().equals("")) {
							break;
						}
						
						
						saida.println(linha);
					}
					
					saida.close();
					teclado.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		Thread threadRecebeResposta = new Thread(new Runnable() {
			
			@Override
			public void run() {


				try {
					System.out.println("Recebendo dados do servidor: ");
					Scanner respostaServidor = new Scanner(socket.getInputStream());
					
					while (respostaServidor.hasNextLine()) {
						String linha = respostaServidor.nextLine();
						System.out.println(linha);
					}
					
					respostaServidor.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				
			}
		});
		
		threadRecebeResposta.start();
		threadEnviaComando.start();
		
		// faz que a thread que executa essa linha fica esperando (no nosso caso main). 
		// só volta a ser executada quando `threadEnviaComando` terminar.
		threadEnviaComando.join();

		System.out.println("Fechando socket do cliente!");
		
		socket.close();
	}
	
	//Vai esperar os 30s e depois vai continuar a execucao do bloco mesmo que a outra Thread não tenha terminado
	//thread.join(30000);

}
