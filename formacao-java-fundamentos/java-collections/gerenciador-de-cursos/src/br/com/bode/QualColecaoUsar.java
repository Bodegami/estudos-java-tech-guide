package br.com.bode;

import java.util.Collection;
import java.util.HashSet;

public class QualColecaoUsar {
	
	public static void main(String[] args) {
		
		Collection<Aluno> alunos = new HashSet<>();
		alunos.size();
		alunos.add(null);
		//alunos.get(56); -> não faz parte da interface Collection
		
	}

}
