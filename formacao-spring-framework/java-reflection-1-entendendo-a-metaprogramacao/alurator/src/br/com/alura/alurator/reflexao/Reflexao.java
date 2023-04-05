package br.com.alura.alurator.reflexao;

public class Reflexao {

	public ManipuladorDeClasse refleteClasse(String fullQualifiedName) {
		try {
			Class<?> classe = Class.forName(fullQualifiedName);
			
			return new ManipuladorDeClasse(classe);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
