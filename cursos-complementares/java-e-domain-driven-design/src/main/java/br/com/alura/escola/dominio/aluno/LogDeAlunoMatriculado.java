package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

//Um dos ouvintes do evento AlunoMatriculado
public class LogDeAlunoMatriculado {
	
	public void reageAo(AlunoMatriculado evento) {
		String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		System.out.println(
				String.format(
						"Aluno com CPD %s matriculado em: %s", 
						evento.getCpfDoAluno().getNumero(),
						momentoFormatado));
	}

}
