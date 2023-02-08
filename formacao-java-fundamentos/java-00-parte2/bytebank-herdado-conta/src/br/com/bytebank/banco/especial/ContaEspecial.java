package br.com.bytebank.banco.especial;

import br.com.bytebank.banco.modelo.Conta;

public class ContaEspecial extends Conta {
	
	/*
	 * MODIFICADORES DE ACESSO:
	 * 
	 * public -> visivel para todas as classes
	 * protected -> visivel somente para os filhos
	 * <package private> -> visivel somente dentro do package
	 * private -> visivel somente dentro da classe	 * 
	 * 
	 */
	
	

	public ContaEspecial(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		// saldo não é visivel
		super.saldo += valor;

	}

}
