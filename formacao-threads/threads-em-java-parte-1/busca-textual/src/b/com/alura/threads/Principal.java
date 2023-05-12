package b.com.alura.threads;

public class Principal {
	
	//Não temos controle sobre a ordem de execução das Threads
	public static void main(String[] args) {
		
		String nome = "da";
		
		Thread threadAssinatura1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
		Thread threadAssinatura2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
		Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome));
		
		threadAssinatura1.start();
		threadAssinatura2.start();
		threadAutores.start();
	}

}
