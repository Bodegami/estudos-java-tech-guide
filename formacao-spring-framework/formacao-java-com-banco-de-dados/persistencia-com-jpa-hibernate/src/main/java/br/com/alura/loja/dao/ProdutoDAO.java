package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nomeRequest) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nomeRequest)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nomeRequest) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter(1, nomeRequest)
                .getResultList();
    }


}
