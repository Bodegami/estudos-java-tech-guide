package br.com.alura.leilao.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;

class GeradorDePagamentoTest {
	
	private GeradorDePagamento gerador;
	
	@Mock
	private PagamentoDao pagamentoDao;
	
	@Captor
	private ArgumentCaptor<Pagamento> captor;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.gerador = new GeradorDePagamento(pagamentoDao);
	}

	@Test
	void deveriaCriarPagamentoParaVencedorDoLeilao() {
		Leilao leilao = leilao();
		Lance vencedor = leilao.getLanceVencedor();
		gerador.gerarPagamento(vencedor);
		
		//Utilizamos essa abordagem quando queremos capturar um objeto que é criado dentro de um metodo
		Mockito.verify(pagamentoDao).salvar(captor.capture());
		
		//Com o captor conseguimos capturar o objeto no momento em que ele é passado o mock
		Pagamento pagamento = captor.getValue();
		
		Assertions.assertEquals(LocalDate.now().plusDays(1), pagamento.getVencimento());
		Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
		Assertions.assertFalse(pagamento.getPago());
		Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
		Assertions.assertEquals(leilao, pagamento.getLeilao());
	}
	
	private Leilao leilao() {
		Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));

		Lance lance = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

		leilao.propoe(lance);
		leilao.setLanceVencedor(lance);

		return leilao;

	}

}
