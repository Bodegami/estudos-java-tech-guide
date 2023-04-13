package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TesteCriteria {

    public static void main(String[] args) {
        popularBancoDeDadosComPedidos();
        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        List<Produto> ps5 = produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
        System.out.println(ps5);
    }

    private static void popularBancoDeDadosComPedidos() {
        popularBancoDeDadosComCategoriasEProdutos();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Produto produto1 = produtoDao.buscarPorId(1L);
        Produto produto2 = produtoDao.buscarPorId(2L);
        Produto produto3 = produtoDao.buscarPorId(3L);
        Cliente cliente = clienteDao.buscarPorId(1L);

        em.getTransaction().begin();

        Pedido pedido1 = new Pedido(cliente);
        pedido1.adicionarItem(new ItemPedido(10, pedido1, produto1));
        pedido1.adicionarItem(new ItemPedido(5, pedido1, produto2));

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(10, pedido2, produto3));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido1);
        pedidoDao.cadastrar(pedido2);

        em.getTransaction().commit();

    }

    private static void popularBancoDeDadosComCategoriasEProdutos() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videoGames = new Categoria("PS5");
        Categoria headsets = new Categoria("HEADSETS");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
        Produto videoGame = new Produto("Playstation 5", "Muito legal", new BigDecimal("4000"), videoGames );
        Produto headset = new Produto("Logitech G435", "Muito legal", new BigDecimal("280"), headsets );

        Cliente cliente = new Cliente("Renato", "12345");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videoGames);
        categoriaDao.cadastrar(headsets);


        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videoGame);
        produtoDao.cadastrar(headset);


        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }

}
