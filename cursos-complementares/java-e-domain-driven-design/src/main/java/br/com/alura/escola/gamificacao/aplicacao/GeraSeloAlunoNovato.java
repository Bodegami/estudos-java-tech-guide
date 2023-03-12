package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

	private final RepositorioDeSelos repositorio;

	public GeraSeloAlunoNovato(RepositorioDeSelos repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	protected void reageAo(Evento evento) {
		CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
		Selo novato = new Selo(cpfDoAluno, "Novato");
		repositorio.adicionar(novato);
		
		System.out.println(String.format("Aluno do CPF %s ganhou o selo::: NOVATO", cpfDoAluno));
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
	}

}
