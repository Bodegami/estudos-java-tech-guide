package br.com.alura.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//AGGREATE ROOT
public class Aluno {
	
	private CPF cpf;
	private String nome;
	
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha;
	
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd, String numero) {
		// regra de negocio == business invariant
		// Invariantes nada mais são do que regras de negócio que precisam ser verificadas 
		// para garantir sua consistência.
		
		if (telefones.size() == 2) {
			throw new NumeroMaximoTelefones("numero maximo de telefones já atingido!");
		}
		this.telefones.add(new Telefone(ddd, numero));
	}
	
	public CPF getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}
	
	public List<Telefone> getTelefones() {
		return Collections.unmodifiableList(telefones);
	}

	public String getSenha() {
		return senha;
	}
	
}
