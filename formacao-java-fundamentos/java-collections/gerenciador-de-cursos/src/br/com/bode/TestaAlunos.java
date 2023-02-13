package br.com.bode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		/**
		 * 
		 * Interface Set:
		 * 
		 * A primeira caracteristica que podemos observar é que o Set não tem uma ordenação
		 * por criterio de primeiro elemento adicionado.
		 * 
		 * Outro ponto que o Set não possui um metodo "get" para buscar um elemento dentro do
		 * conjunto.
		 * 
		 * O Set também não aceita elementos repetidos. Podemos chamar o metodo add e passar
		 * um elemento repetido, que o Set irá ignorar aquele elemento quando ele indenticar 
		 * que o mesmo já existe em sua estrutura.
		 * 
		 * O Set é extremamente performatico para metodos como contains ou remove, isso pq internamente
		 * ele utiliza uma "tabela de espalhamento" o que difere da forma como as classes que implementam
		 * a interface List trabalham. 
		 * Vale a pena estudar mais afundo sobre como funciona a tabela de espalhamento.
		 * 
		 * O conjunto Set também não aceita ou implementa a interface Comparable e nem podemos
		 * utiliza-lo com o Comparator.
		 * 
		 * 
		 */
		
		
		Set<String> alunos = new HashSet<>();
		alunos.add("Rodrigo Turini");
		alunos.add("Alberto Souza");
		alunos.add("Nico Steppat");
		
		System.out.println(alunos);
		
		alunos.add("Sergio Lopes");
		alunos.add("Renan Saggio");
		alunos.add("Mauricio Aniche");
		alunos.add("Alberto Souza");
		
		System.out.println(alunos);
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		System.out.println("Quantidade de alunos: " + alunos.size());
		
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");
		System.out.println(pauloEstaMatriculado);
		
		alunos.remove("Sergio Lopes");
		System.out.println(alunos);
		
		//Se for o caso de precisar recuperar um elemento especifico do conjunto, podemos seguir
		//com essa abordagem:
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		System.out.println(alunosEmLista.get(3));
		
		//Alem disso, agora podemos ordenar a lista.
		//Collections.sort(alunosEmLista);
		alunosEmLista.sort((aluno1, aluno2) -> aluno1.compareTo(aluno2));
		System.out.println(alunosEmLista);
		
		
	}
	
}
