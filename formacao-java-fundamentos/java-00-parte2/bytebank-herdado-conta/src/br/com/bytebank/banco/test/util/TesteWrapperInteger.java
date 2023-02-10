package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		int[] idades = new int[5];
		String[] nomes  = new String[5];
		
		//As interfaces só aceitam referencias. Quando passamos um tipo primitivo, por de baixo dos
		//dos panos ela usa a referencia (Wrapper) deste tipo
		//Ex: List<int> numero = new ArrayList<>(); -> não compila pois a interface não aceita tipos primitivos
		
		int idade = 29;// Integer
		Integer idadeRef = Integer.valueOf(idade);//Autoboxing -> tranformacao do tipo primitivo para objeto
		
		System.out.println(idadeRef.doubleValue());
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE);
		System.out.println(Integer.BYTES);
		
		int valor = idadeRef.intValue();//Unboxing -> transformacao do objeto para tipo primitivo
		String s = args[0];//"10"
		//Integer numero = Integer.valueOf(s);
		int numero = Integer.parseInt(s);
		System.out.println(s);
		
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(29);
		
		
	}
	
}
