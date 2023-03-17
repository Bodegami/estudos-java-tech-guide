package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		empresa1.setId(Banco.chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(Banco.chaveSequencial++);
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while (it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) { 
				it.remove();
			}	
		}		
	}
		
}
