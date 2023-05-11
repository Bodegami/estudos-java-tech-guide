package br.com.alura.banheiro;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			while (ehSujo) {
				espera_la_fora(nome);
			}
			
			System.out.println(nome + " fazendo coisa rapida");
			
			dormeUmPouco(5000);
			
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			while (ehSujo) {
				espera_la_fora(nome);
			}
			
			System.out.println(nome + " fazendo coisa demorada");
			
			dormeUmPouco(10000);
			
			this.ehSujo = true;
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void dormeUmPouco(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limpa() {

	    String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");

	        if (!this.ehSujo) {
	            System.out.println(nome + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(nome + " limpando o banheiro");
	        this.ehSujo = false;

	        try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
	    }
	}
	
	private void espera_la_fora(String nome) {
		System.out.println(nome + ", eca, banheiro ta sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
