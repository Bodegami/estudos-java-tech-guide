package br.com.alura.escola.aluno;

public class Email {
	
	//VALUE OBJECT
	
	private String endereco;

	public Email(String endereco) {
		if (endereco == null || !endereco.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new IllegalArgumentException("E-mail invalido!");
		}
		
		this.endereco = endereco;
	}

	public String getEndereco() {
		return this.endereco;
	}
	
}
