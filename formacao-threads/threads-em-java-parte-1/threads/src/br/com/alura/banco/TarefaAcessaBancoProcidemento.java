package br.com.alura.banco;

public class TarefaAcessaBancoProcidemento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcidemento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		
		synchronized (pool) {
			System.out.println("peguei a conexao");
			tx.begin();
			
			synchronized (tx) {
				System.out.println("comecando a tx");
				pool.getConnection();
			}
		}

	}

}
