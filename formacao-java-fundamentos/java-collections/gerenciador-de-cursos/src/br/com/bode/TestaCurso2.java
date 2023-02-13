package br.com.bode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com o ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		//Dessa forma podemos criar um novo ArrayList usando os elementos da nosa lista imutavel
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		System.out.println(aulas);
		
		System.out.println("Tempo total aulas via metodo: " + javaColecoes.getTempoTotal());
		System.out.println("Tempo total aulas via atributo: " + javaColecoes.getTempoTotalCurso());
		
		System.out.println(javaColecoes);

	}

}
