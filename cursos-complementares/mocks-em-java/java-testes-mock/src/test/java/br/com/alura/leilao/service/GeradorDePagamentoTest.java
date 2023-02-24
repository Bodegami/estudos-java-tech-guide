package br.com.alura.leilao.service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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

	@Mock
	private Clock clock;

	@Captor
	private ArgumentCaptor<Pagamento> captor;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.gerador = new GeradorDePagamento(pagamentoDao, clock);
	}

	@Test
	void deveriaCriarPagamentoParaVencedorDoLeilao() {
		Leilao leilao = leilao();
		Lance vencedor = leilao.getLanceVencedor();
		
		//Mockamos um data fixa, para que o teste não quebre independente da data
		LocalDate data = LocalDate.of(2022, 12, 5);
		
		//Convertemos para um objeto do tipo Instant 
		Instant instant = data.atStartOfDay(ZoneId.systemDefault()).toInstant();
		
		//Chamamos o metodo instant do Clock e passamos o objeto Instant como retorno
		Mockito.when(clock.instant()).thenReturn(instant);
		
		//Quando o metodo getZone for chamado, ele deve retornar o systemDefault
		Mockito.when(clock.getZone()).thenReturn(ZoneId.systemDefault());
		
		gerador.gerarPagamento(vencedor);

		// Utilizamos essa abordagem quando queremos capturar um objeto que é criado
		// dentro de um metodo
		Mockito.verify(pagamentoDao).salvar(captor.capture());

		// Com o captor conseguimos capturar o objeto no momento em que ele é passado o mock
		Pagamento pagamento = captor.getValue();

		Assertions.assertEquals(data.plusDays(1), pagamento.getVencimento());
		Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
		Assertions.assertFalse(pagamento.getPago());
		Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
		Assertions.assertEquals(leilao, pagamento.getLeilao());
	}
	
	@Test
	void deveriaCriarPagamentoParaVencedorDoLeilaoAposDoisDiasQuandoForSabado() {
		Leilao leilao = leilao();
		Lance vencedor = leilao.getLanceVencedor();
		
		LocalDate data = LocalDate.of(2022, 12, 10);
		Instant instant = data.atStartOfDay(ZoneId.systemDefault()).toInstant();

		Mockito.when(clock.instant()).thenReturn(instant);
		Mockito.when(clock.getZone()).thenReturn(ZoneId.systemDefault());
		
		gerador.gerarPagamento(vencedor);

		Mockito.verify(pagamentoDao).salvar(captor.capture());

		Pagamento pagamento = captor.getValue();

		Assertions.assertEquals(data.plusDays(2), pagamento.getVencimento());
		Assertions.assertEquals(vencedor.getValor(), pagamento.getValor());
		Assertions.assertFalse(pagamento.getPago());
		Assertions.assertEquals(vencedor.getUsuario(), pagamento.getUsuario());
		Assertions.assertEquals(leilao, pagamento.getLeilao());
	}
	
	@Test
	void deveriaCriarPagamentoParaVencedorDoLeilaoAposUmDiaQuandoForDomingo() {
		Leilao leilao = leilao();
		Lance vencedor = leilao.getLanceVencedor();
		
		LocalDate data = LocalDate.of(2022, 12, 11);
		Instant instant = data.atStartOfDay(ZoneId.systemDefault()).toInstant();

		Mockito.when(clock.instant()).thenReturn(instant);
		Mockito.when(clock.getZone()).thenReturn(ZoneId.systemDefault());
		
		gerador.gerarPagamento(vencedor);

		Mockito.verify(pagamentoDao).salvar(captor.capture());

		Pagamento pagamento = captor.getValue();

		Assertions.assertEquals(data.plusDays(1), pagamento.getVencimento());
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
