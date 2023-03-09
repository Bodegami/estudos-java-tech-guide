package br.com.alura.escola.indicacao;

import java.time.LocalDateTime;

public class Indicacao {

	private String indicado;
	private String indicante;
	private LocalDateTime dataIndicacao;

	public Indicacao(String indicado, String indicante, LocalDateTime dataIndicacao) {
		this.indicado = indicado;
		this.indicante = indicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public String getIndicado() {
		return indicado;
	}

	public String getIndicante() {
		return indicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}

}
