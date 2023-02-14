package br.com.bode;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoAluno {

	public static void main(String[] args) {
		
		// Ao trabalhar com Set<Aluno>, é importante sobreescrever os metodos equals e hashCode
		
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com o ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		
		Aluno a1 = new Aluno("Rodrigo Turini", 24672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5617);
		Aluno a3 = new Aluno("Mauricio Aniche", 17645);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos alunos matriculados: ");
		javaColecoes.getAlunos().forEach(System.out::println);
		
		System.out.println("O aluno " + a1 + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		//Detalhe aqui é que após percorrer todos os elementos do "iterador", caso houvesse a necessidade
		//de percorrer novamente, seria necessario criar um novo "alunos.iterator()"
		System.out.println("Iterando sobre um conjunto em versoes anteriores ao Java 5: ");
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		int count = 0;
		while (iterador.hasNext()) {
			
			Aluno proximoAluno = iterador.next();
			System.out.printf("Iterador %s: %s\n", count++, proximoAluno);
		}
		
		
		//Sobreescrevemos o metodo hashCode para que seja possivel validar se um elemento está no conjunto
		Aluno turini = new Aluno("Rodrigo Turini", 24672);
		System.out.println("E esse Turini está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		//Sobreescrevemos o equals para que seja possivel fazer a comparacao pelo nome
		System.out.println("O a1 é equals ao Turini?");
		System.out.println(a1.equals(turini));
		
		// obrigatoriamente o seguinte é true:
		System.out.println(a1.hashCode() == turini.hashCode());
		
	}
	
}
