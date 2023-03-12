package br.com.alura.escola.infra.selo;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.dominio.selo.Selo;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {
	
private List<Selo> atribuidos = new ArrayList<>();
	
	@Override
	public void atribuir(Selo selo) {
		this.atribuidos.add(selo);
	}

	@Override
	public Selo buscarPorCPF(CPF cpf) {
		return this.atribuidos.stream()
				.filter(a -> a.getCpfDoAluno().getNumero().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Selo> listarTodosSelosAtribuidos() {
		return this.atribuidos;
	}

}
