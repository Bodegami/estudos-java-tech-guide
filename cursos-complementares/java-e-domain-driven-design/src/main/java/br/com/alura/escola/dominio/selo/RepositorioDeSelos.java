package br.com.alura.escola.dominio.selo;

import java.util.List;

import br.com.alura.escola.dominio.aluno.CPF;

public interface RepositorioDeSelos {
	
	void atribuir(Selo selo);
	
	Selo buscarPorCPF(CPF cpf);
	
	List<Selo> listarTodosSelosAtribuidos();

}
