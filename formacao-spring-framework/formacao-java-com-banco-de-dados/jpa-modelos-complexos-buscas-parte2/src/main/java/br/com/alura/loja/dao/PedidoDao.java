package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.vo.RelatorioDeVendasVO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> buscarTodos() {
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public List<RelatorioDeVendasVO> relatorioDeVendas() {
//		String jpql = "SELECT produto.nome, " +
//				"SUM(item.quantidade), " +
//				"MAX(pedido.data) " +
//				"FROM Pedido pedido " +
//				"JOIN pedido.itens item " +
//				"JOIN item.produto produto " +
//				"GROUP BY produto.nome " +
//				"ORDER BY item.quantidade DESC";

		//Utilizamos o Select new FullQualifiedName quando queremos dizer que o retorno da query
		//será representado por uma classe do sistema.

		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVO(" +
				"produto.nome, " +
				"SUM(item.quantidade), " +
				"MAX(pedido.data)) " +
				"FROM Pedido pedido " +
				"JOIN pedido.itens item " +
				"JOIN item.produto produto " +
				"GROUP BY produto.nome " +
				"ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, RelatorioDeVendasVO.class).getResultList();
	}

}
