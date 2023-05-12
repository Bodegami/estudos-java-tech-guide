package br.com.alura.lista;

public class Principal {
    public static void main(String[] args) throws Exception {
    	

    	Lista lista = new Lista();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new TarefaAdicionarElemento(lista, i));
            thread.start();
        } 

        new Thread(new TarefaImprimir(lista)).start();
        
        Thread.sleep(2000);
        


    } 

} 
