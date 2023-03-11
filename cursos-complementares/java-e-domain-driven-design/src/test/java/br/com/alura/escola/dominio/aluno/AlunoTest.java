package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno aluno;
	private String ddd;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	@BeforeEach
	public void setup() {
		
		this.aluno = new Aluno(
						new CPF("123.456.789-00"),
						"Fulano",
						new Email("fulano@email.com.br"));
		this.ddd = "13";
		this.telefone1 = "987654321";
		this.telefone2 = "932165498";
		this.telefone3 = "965432187";
		
	}

	@Test
	void deveriaCadastrarNoMaximoDoisTelefonesPorAluno() {
		
		this.aluno.adicionarTelefone(this.ddd, this.telefone1);
		this.aluno.adicionarTelefone(this.ddd, this.telefone2);
		
		assertEquals(this.telefone1, this.aluno.getTelefones().get(0).getNumero());
		assertEquals(this.telefone2, this.aluno.getTelefones().get(1).getNumero());
	}
	
	@Test
	void naoDeveCadastrarMaisDeDoisTelefonesPorAluno() {

		assertThrows(NumeroMaximoTelefones.class, () -> {
			this.aluno.adicionarTelefone(this.ddd, this.telefone1);
			this.aluno.adicionarTelefone(this.ddd, this.telefone2);
			this.aluno.adicionarTelefone(this.ddd, this.telefone3);
		});
	}

}
