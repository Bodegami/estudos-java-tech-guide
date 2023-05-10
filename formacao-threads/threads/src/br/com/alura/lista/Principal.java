package br.com.alura.lista;

import java.util.List;
import java.util.Vector;

public class Principal {
    public static void main(String[] args) throws Exception {
    	
    	/**
    	 * THREAD SAFE:
    	 * 
    	 * Map mapaThreadSafe = new Hashtable();
    	 * 
    	 * Map mapaThreadSafe = new ConcurrentHashMap();
    	 * 
    	 * Set conjunto = Collections.synchronizedSet(new HashSet());
    	 * 
    	 * Queue filaThreadSafe = new BlockingQueue();
    	 * 
    	 * Queue filaThreadSafe = new ArrayBlockingQueue();
    	 * 
    	 */
    	

        //List<String> lista = Collections.synchronizedList(new ArrayList<String>());
    	List<String> lista = new Vector<String>();
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new TarefaAdicionarElemento(lista, i));
            thread.start();
        } 
        
        Thread.sleep(2000);
        
        for (int i = 0; i < lista.size(); i++) {
        	System.out.println(i + " - " + lista.get(i));
        }

    } 

} 
