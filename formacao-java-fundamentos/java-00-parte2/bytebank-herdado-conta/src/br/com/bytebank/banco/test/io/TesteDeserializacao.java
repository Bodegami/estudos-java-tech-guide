package br.com.bytebank.banco.test.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteDeserializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
		ContaCorrente cc = (ContaCorrente) ois.readObject(); 
		ois.close();
		
		/**
		 * 
		 * Na classe Conta, colocamos a palavra chave "transient" no atributo Cliente.
		 * Isso faz com que, quando um objeto conta for serializado, o atributo cliente será ignorado
		 * e sua refeência ficara como null. 
		 * 
		 */
		System.out.println(cc.getTitular());
		System.out.println(cc.getSaldo());
	}
	
}
