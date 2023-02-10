package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29);//Autoboxing
		System.out.println(idadeRef.intValue());//Unboxing
		
		
		Double dRef = Double.valueOf(3.2);//Autoboxing
		System.out.println(dRef.doubleValue());//Unboxing
		
		
		Boolean bRef = Boolean.FALSE;//Autoboxing
		System.out.println(bRef.booleanValue());//Unboxing
		
		
		Number refNumero = Float.valueOf(29.9f);
		System.out.println(refNumero.floatValue());
		
		List<Number> lista = new ArrayList<>();
		lista.add(10);
		lista.add(32.6);
		lista.add(29.9f);
		System.out.println(lista);
		
		
	}
	
}
