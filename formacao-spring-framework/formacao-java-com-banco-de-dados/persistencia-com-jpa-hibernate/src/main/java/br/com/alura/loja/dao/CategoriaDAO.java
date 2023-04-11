package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    //Merge pega um objeto em estado 'Detached' e muda para o estado 'Managed'
    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    //Primeiro com o Merge, pegamos um objeto em estado 'Detached' e mudamos para o estado 'Managed'
    //Depois com o objeto em estado 'Managed', chamamos o 'remove' que muda o estado para 'Removed'
    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }
}
