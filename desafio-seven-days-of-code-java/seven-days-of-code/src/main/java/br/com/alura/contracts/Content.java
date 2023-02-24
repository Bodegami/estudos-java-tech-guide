package br.com.alura.contracts;

public interface Content extends Comparable<Content>{
	
	String title();
	String urlImage();
	String rating();
	String year();
	String type();
}
