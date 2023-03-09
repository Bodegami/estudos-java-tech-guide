package escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CpfTest {

	@Test
	void naoDeveriaCriarCpfComRegistroInvalido() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Cpf("1234567890123"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Cpf("123456"));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Cpf("cpfinvalido"));
	}
	
	@Test
	void deveriaCriarCpfComRegistroValido() {
		String registro1 = "123.456.789-11";
		String registro2 = "12345678911";
		
		Cpf cpf1 = new Cpf(registro1);
		Cpf cpf2 = new Cpf(registro2);
		
		assertEquals(registro1, cpf1.getRegistro());
		assertEquals(registro2, cpf2.getRegistro());
	}

}
