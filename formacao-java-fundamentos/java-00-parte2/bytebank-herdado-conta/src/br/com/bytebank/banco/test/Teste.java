package br.com.bytebank.banco.test;

public class Teste {

	//Array []
	public static void main(String[] args) {
		
		int[] idades = new int[5];//inicializa um array de 5 posicoes com os valores padroes (0)
		System.out.println(idades[0]);
		
		for (int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
		}
		
		for (int i = 0; i < idades.length; i++) {
			System.out.println(idades[i]);
		}
	}
}
