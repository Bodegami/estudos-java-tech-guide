package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Produto produto = new Produto("Xiaomi Redmi",
                "Celular maneiro", new BigDecimal("800"), Categoria.CELULARES);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);

        try {
            em.getTransaction().begin();
            dao.cadastrar(produto);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        em.close();
    }
}
