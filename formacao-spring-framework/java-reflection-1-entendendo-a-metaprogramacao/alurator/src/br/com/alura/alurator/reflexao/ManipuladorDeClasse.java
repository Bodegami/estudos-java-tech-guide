package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorDeClasse {
	
	private Class<?> classe;

	public ManipuladorDeClasse(Class<?> classe) {
		this.classe = classe;
	}

	public ManipuladorDeConstrutor getConstrutorPadrao() {
		try {
			Constructor<?> construtorPadrao = this.classe.getDeclaredConstructor();
			return new ManipuladorDeConstrutor(construtorPadrao);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
