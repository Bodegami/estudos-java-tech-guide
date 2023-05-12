package b.com.alura.threads;

public class TarefaImprimeNumeros implements Runnable {

	@Override
	public void run() {
		int count = 1;
		while (count < 1000) {
			Thread threadAtual = Thread.currentThread();
			long id = threadAtual.getId();
			System.out.println("Id da thread: " + id + " | Count: " + count);
			count++;
		}

	}

}
