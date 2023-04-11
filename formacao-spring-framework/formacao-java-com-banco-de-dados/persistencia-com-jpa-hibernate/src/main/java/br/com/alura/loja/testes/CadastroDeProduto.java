package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Produto produto = new Produto();
        produto.setNome("Xiaomi Redmi");
        produto.setDescricao("Celular maneiro");
        produto.setPreco(new BigDecimal("800"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(produto);

            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        em.close();
        emf.close();

    }
}
