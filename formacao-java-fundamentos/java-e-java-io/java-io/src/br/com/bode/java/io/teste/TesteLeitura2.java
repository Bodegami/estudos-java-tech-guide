package br.com.bode.java.io.teste;

import java.io.File;
import java.util.Scanner;

public class TesteLeitura2 {

	public static void main(String[] args) throws Exception {
		
		try (Scanner scanner = new Scanner(new File("contas.csv"))) {
			
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				System.out.println(linha);
			}
			
			scanner.close();
		} catch (Exception e) {
			System.out.println("Class: " + e.getClass().getSimpleName());
			System.out.println("Message: " + e.getMessage());
		}
		
		

		
		
		
		
		
		
	}

}
