package br.com.bode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();
	//new LinkedHashSet<>(); -> O LinkedHashSet guarda a ordem de adição dos elementos
	//new TreeSet()<>(); -> utiliza a estrutura "arvore rubro negra" e precisa que a classe implemente o Comparable
	private Set<Aluno> alunos = new HashSet<>();
	//podemos usar tb o LinkedHashMap para ter um mapa ordenado por ordem de adição
	//podemos usar o Hashtable para Thread Safe
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	private int tempoTotalCurso;



	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	// Programacao defensiva, dessa forma evitamos que alguem chame o metodo add da
	// interface List
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
		this.tempoTotalCurso += aula.getTempo();
	}
	
	public int getTempoTotalCurso() {
		return tempoTotalCurso;
	}

	public int getTempoTotal() {
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	
	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() 
		+ ", aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getMatricula(), aluno);
	}

	public boolean estaMatriculado(Aluno a1) {
		return this.alunos.contains(a1);
	}

	public Aluno buscaMatriculado(int numero) {
		if (!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException("aluno nao encontrado");
		}
		return matriculaParaAluno.get(numero);
	}

}
