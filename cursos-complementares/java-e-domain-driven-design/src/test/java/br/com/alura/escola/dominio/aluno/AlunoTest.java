package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AlunoTest {

	@Test
	void deveriaCadastrarNoMaximoDoisTelefonesPorAluno() {
		
		Aluno aluno = new Aluno(new CPF("123.456.789-00"), "Fulano", new Email("fulano@email.com.br"));
		
		String ddd = "13";
		String telefone1 = "987654321";
		String telefone2 = "932165498";
		
		aluno.adicionarTelefone(ddd, telefone1);
		aluno.adicionarTelefone(ddd, telefone2);
		
		assertEquals(telefone1, aluno.getTelefones().get(0).getNumero());
		assertEquals(telefone2, aluno.getTelefones().get(1).getNumero());
	}
	
	@Test
	void naoDeveCadastrarMaisDeDoisTelefonesPorAluno() {
		Aluno aluno = new Aluno(new CPF("123.456.789-00"), "Fulano", new Email("fulano@email.com.br"));
		
		String ddd = "13";
		String telefone1 = "987654321";
		String telefone2 = "932165498";
		String telefone3 = "965432187";
		
		assertThrows(NumeroMaximoTelefones.class, () -> {
			aluno.adicionarTelefone(ddd, telefone1);
			aluno.adicionarTelefone(ddd, telefone2);
			aluno.adicionarTelefone(ddd, telefone3);
		});
	}

}
