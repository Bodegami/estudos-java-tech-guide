package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
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

    //Merge pega um objeto em estado 'Detached' e muda para o estado 'Managed'
    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    //Primeiro com o Merge, pegamos um objeto em estado 'Detached' e mudamos para o estado 'Managed'
    //Depois com o objeto em estado 'Managed', chamamos o 'remove' que muda o estado para 'Removed'
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


}
