package escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidados() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(""));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email("emailinvalido"));
	}
	
	@Test
	void deveriaCriarEmailsComEnderecosValidados() {
		String endereco = "teste@gmail.com";
		
		Email email = new Email(endereco);
		
		assertEquals(endereco, email.getEndereco());
	}

}
