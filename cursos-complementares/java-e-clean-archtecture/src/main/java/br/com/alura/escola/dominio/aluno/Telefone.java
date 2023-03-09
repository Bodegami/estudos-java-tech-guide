package br.com.alura.escola.dominio.aluno;

public class Telefone {

	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		
		if (ddd == null || !ddd.matches("([0-9]{2,3})")) {
			throw new IllegalArgumentException("DDD invalido!");
		}

		if (numero == null || !numero.matches("([0-9]{4,5})([0-9]{4})")) {
			throw new IllegalArgumentException("Numero invalido!");
		}

		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
