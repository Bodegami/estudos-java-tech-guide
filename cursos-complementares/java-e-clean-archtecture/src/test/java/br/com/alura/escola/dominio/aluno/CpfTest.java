package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CpfTest {

	@Test
	void naoDeveriaCriarCpfComRegistroInvalido() {
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF("1234567890123"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF("123456"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new CPF("cpfinvalido"));
	}
	
	@Test
	void deveriaCriarCpfComRegistroValido() {
		String registro1 = "123.456.789-11";
		String registro2 = "12345678911";
		
		CPF cpf1 = new CPF(registro1);
		CPF cpf2 = new CPF(registro2);
		
		assertEquals(registro1, cpf1.getRegistro());
		assertEquals(registro2, cpf2.getRegistro());
	}

}
