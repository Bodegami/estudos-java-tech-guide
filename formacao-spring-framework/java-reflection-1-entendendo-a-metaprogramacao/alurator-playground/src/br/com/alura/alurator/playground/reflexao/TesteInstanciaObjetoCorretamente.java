package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, 
				NoSuchMethodException, SecurityException, IllegalArgumentException {
		
		Class<SubControle> subControleClasse1 =  SubControle.class; 
		
		Class<?> subControleClasse2 = 
				Class.forName("br.com.alura.alurator.playground.controle.SubControle");

		Class<?> controleClasse1 = 
				Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		try {
			controleClasse1.getDeclaredConstructor().newInstance();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
			System.out.println(e.getTargetException());
		}
		
		//controleClasse1.newInstance();
		

//		//getConstructor() retorna qualquer construtor publico
//		Constructor<SubControle> constructorSubControle = subControleClasse1.getDeclaredConstructor();
//		System.out.println(constructorSubControle);
//		
//		//getDeclaredConstructor() retorna qualquer construtor de qualquer tipo de modificar de acesso
//		Constructor<SubControle> constructorSubControleComParametros = 
//				subControleClasse1.getDeclaredConstructor(String.class);
//		System.out.println(constructorSubControleComParametros);
//		
//		
//		// Por padrao o newInstance do Constructor não permite recuperar construtores privados de uma classe,
//		//mas podemos mudar esse comportamento com o metodo setAccessible() passando 'true' como parametro.
//		constructorSubControle.setAccessible(true);
//		Object subControle = constructorSubControle.newInstance();
//		
//		System.out.println(subControle);
//		System.out.println(subControle instanceof SubControle);
		
		
	}

}
