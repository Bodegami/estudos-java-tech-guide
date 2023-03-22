package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {

	public static void main(String[] args) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		// url -> /controle/lista
		
		Class<Controle> controleClasse1 =  Controle.class; //Primeira forma
		
		Controle controle = new Controle();
		
		// A sintaxe <? extends Controle> indica que é valido para a classe mae Controle e suas filhas.
		Class<? extends Controle> controleClasse2 = controle.getClass(); //Segunda forma
		
		// Aqui tem detalhe que dessa forma ele pode lançar a ClassNotFoundException caso não encontre a classe.
		// Outro ponto é que como passamos um String com o full qualified name, o java não tem como determinar
		//qual a classe que essa String representa, e nesse caso ele utiliza o '?' dentro do generics.
		Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");// Terceira forma
		
		// Metodo depreciado
		// Aqui o java sabe que é um objeto do tipo Controle, por conta da pista que demos a ele no 'controleClasse1'.
		Controle objetoControle = controleClasse1.newInstance();
		
		System.out.println(objetoControle instanceof Controle);
		
		// Já aqui não funciona inferencia da classe Controle, pq no objeto controleClasse3, usamos a inferencia '?'
		//dentro do Class, logo o java não sabe qual a classe.
		Object outroObjetoControle = controleClasse3.newInstance();
		
		System.out.println(outroObjetoControle instanceof Controle);
		
	}

}
