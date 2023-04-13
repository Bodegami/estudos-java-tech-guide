package br.com.alura.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

	//Utilizamos essa anotacao para indicar qual classe que representa a chave composta
	@EmbeddedId
	private CategoriaId id;
	
	public Categoria() {
	}
	
	public Categoria(String nome) {

		this.id = new CategoriaId(nome, "xpto");
	}

	public String getNome() {
		return this.id.getNome();
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				'}';
	}
}
