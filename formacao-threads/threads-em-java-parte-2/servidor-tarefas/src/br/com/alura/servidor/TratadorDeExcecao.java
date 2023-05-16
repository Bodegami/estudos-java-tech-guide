package br.com.alura.servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		System.out.println("Deu excecao na Thread " + t.getId() + ", " + e.getMessage());

	}

}
