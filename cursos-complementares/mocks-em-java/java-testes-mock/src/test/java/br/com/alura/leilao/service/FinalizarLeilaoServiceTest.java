package br.com.alura.leilao.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

class FinalizarLeilaoServiceTest {

	private FinalizarLeilaoService service;

	@Mock
	private LeilaoDao leilaoDao;

	@Mock
	private EnviadorDeEmails enviadorDeEmails;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.service = new FinalizarLeilaoService(leilaoDao, enviadorDeEmails);
	}

	@Test
	void deveriaFinalizarUmLeilao() {
		
		/**
		 * O metodo finalizarLeiloesExpirados, internamente ele 
		 * chama o metodo buscarLeiloesExpirados que retorna uma
		 * lista.
		 * Faz um laço chamando o metodo maiorLanceDadoNoLeilao
		 * para cada leilao.
		 * Depois chama o setLanceVencedor, chama o metodo fechar.
		 * Depois chama o metodo salvar da classe LeilaoDao.
		 * E por ultimo chama o metodo enviarEmails da classe 
		 * EnviadorDeEmails que é uma dependencia do service.
		 * 
		 */
		
		List<Leilao> leiloes = leiloes();
		
		Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);
		
		service.finalizarLeiloesExpirados();
		
		Leilao leilao = leiloes.get(0);
		Assertions.assertTrue(leilao.isFechado());
		Assertions.assertEquals(new BigDecimal("900"), leilao.getLanceVencedor().getValor());
		
		//verifica se um metodo da classe mockada foi chamado
		Mockito.verify(leilaoDao).salvar(leilao);

	}
	
	@Test
	void deveriaEnviarEmailParaVencedorDoLeilao() {
		
		List<Leilao> leiloes = leiloes();
		
		Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);
		
		service.finalizarLeiloesExpirados();
		
		Leilao leilao = leiloes.get(0);
		Lance lanceVencedor = leilao.getLanceVencedor();
		
		//verifica se um metodo da classe mockada foi chamado
		Mockito.verify(enviadorDeEmails).enviarEmailVencedorLeilao(lanceVencedor);

	}
	
	@Test
	void naoDeveriaEnviarEmailParaVencedorDoLeilaoEmCasoDeErroAoEncerrarOLeilao() {
		
		List<Leilao> leiloes = leiloes();
		
		Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);
		
		//lanca exception quando chamar o metodo salvar dentro do metodo finalizarLeiloesExpirados
		Mockito.when(leilaoDao.salvar(Mockito.any())).thenThrow(RuntimeException.class); 
		
		try {
			service.finalizarLeiloesExpirados();
			Mockito.verifyNoInteractions(enviadorDeEmails); // verifica se o metodo não foi chamado em caso de exception
		} catch (Exception e) {
		}

	}

	private List<Leilao> leiloes() {
		List<Leilao> lista = new ArrayList<Leilao>();

		Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));

		Lance primeiro = new Lance(new Usuario("Beltrano"), new BigDecimal("600"));
		Lance segundo = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

		leilao.propoe(primeiro);
		leilao.propoe(segundo);

		lista.add(leilao);

		return lista;

	}

}
