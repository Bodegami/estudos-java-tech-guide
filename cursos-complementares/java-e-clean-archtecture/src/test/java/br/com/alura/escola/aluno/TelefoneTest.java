package br.com.alura.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TelefoneTest {

	@Test
	void naoDeveriaCriarTelefoneComDadosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("3333", "12345678910"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("", ""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(null, null));
	}
	
	@Test
	void deveriaCriarTelefoneComDadosValidos() {
		String ddd = "31";
		String numero = "944445555";
		
		Telefone telefone = new Telefone(ddd, numero);
		
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
	}

}
