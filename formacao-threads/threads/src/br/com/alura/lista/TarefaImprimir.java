package br.com.alura.lista;

public class TarefaImprimir implements Runnable {

	private Lista lista;

	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		
		synchronized(lista) {
			try {
				System.out.println("indo dormir, aguardando notificacao");
				lista.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	        for (int i = 0; i < lista.tamanho(); i++) {
	        	System.out.println(i + " - " + lista.pegaElemento(i));
	        }
		}
		
	}

}
