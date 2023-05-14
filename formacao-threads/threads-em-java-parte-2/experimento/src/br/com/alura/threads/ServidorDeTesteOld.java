package br.com.alura.threads;

public class ServidorDeTesteOld {

	/**
	 * Quando temos mais uma Thread tentando alterar um atributo do metodo main,
	 * poder ocorrer um problema onde dependendo da arquitetura do CPU, a Thread 
	 * vai ter uma memoria cache que faz uma copia desses atributos do metodo main.
	 * Então para indicar que queremos alterar um atributo do metodo main e nao do
	 * cache, utilizamos a palavra chave "volatile" no atributo.
	 */
	
    private volatile boolean estaRodando = false;

    public static void main(String[] args) throws InterruptedException {
        ServidorDeTesteOld servidor = new ServidorDeTesteOld();
        servidor.rodar();
        servidor.alterandoAtributo();
    }

    private void rodar() {
        new Thread(new Runnable() {

            public void run() {
                System.out.println("Servidor começando, estaRodando = " + estaRodando );

                while(!estaRodando) {}

                System.out.println("Servidor rodando, estaRodando = " + estaRodando );

                while(estaRodando) {}

                System.out.println("Servidor terminando, estaRodando = " + estaRodando );
            }
        }).start();
    }

    private void alterandoAtributo() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = true");
        estaRodando = true;

        Thread.sleep(5000);
        System.out.println("Main alterando estaRodando = false");
        estaRodando = false;        
    }
}
