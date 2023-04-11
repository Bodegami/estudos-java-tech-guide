package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        //buscaPeloId();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        List<Produto> todos = produtoDAO.buscarTodos();
        todos.forEach(produto -> System.out.println(produto.getNome()));

    }

    private static void buscaPeloId() {
        Long id = 1L;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        Produto p = produtoDAO.buscarPorId(id);
        System.out.println(p.getPreco());
    }


    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto produto = new Produto("Xiaomi Redmi",
                "Celular maneiro", new BigDecimal("800"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        try {
            em.getTransaction().begin();

            categoriaDAO.cadastrar(celulares);
            produtoDAO.cadastrar(produto);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        em.close();
    }
}
