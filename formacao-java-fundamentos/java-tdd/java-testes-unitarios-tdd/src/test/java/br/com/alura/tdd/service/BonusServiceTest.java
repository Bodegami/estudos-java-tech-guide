package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Renato", LocalDate.now(), new BigDecimal("25000"))));
		
		//Abordagem utilizada quando precisamos validar a message da exception 
//		try {
//			service.calcularBonus(new Funcionario("Renato", LocalDate.now(), new BigDecimal("25000")));
//			fail("Não deu a exception...");
//		} catch (Exception e) {
//			assertEquals("Funcionario com salario maior que 10.000 reais não deve ter bonus!", e.getMessage());
//		}
		
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Renato", LocalDate.now(), new BigDecimal("2500")));
	
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeExatamenteDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Renato", LocalDate.now(), new BigDecimal("10000")));
	
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
	

}
