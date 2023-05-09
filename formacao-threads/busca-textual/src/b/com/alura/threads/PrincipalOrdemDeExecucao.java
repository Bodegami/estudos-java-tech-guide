package b.com.alura.threads;

public class PrincipalOrdemDeExecucao {
	
	public static void main(String[] args) {
		
		TarefaImprimeNumeros contador = new TarefaImprimeNumeros();
		Thread imprimeAteMil1 = new Thread(contador);
		Thread imprimeAteMil2 = new Thread(contador);
		
		imprimeAteMil1.start();
		imprimeAteMil2.start();
	}

}
