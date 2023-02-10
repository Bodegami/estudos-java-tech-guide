package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes  = new String[5];
		
		//As interfaces só aceitam referencias. Quando passamos um tipo primitivo, por de baixo dos
		//dos panos ela usa a referencia (Wrapper) deste tipo
		//Ex: List<int> numero = new ArrayList<>(); -> não compila pois a interface não aceita tipos primitivos
		int idade = 29;// Integer
		Integer idadeRef = new Integer(29);
		List<Integer> numeros = new ArrayList<>();
		numeros.add(29);//Autoboxing -> tranformacao do tipo primitivo para objeto
		
		
	}
	
}
