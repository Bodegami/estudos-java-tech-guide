package br.com.bode.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {
		
		//Fluxo para rede
		Socket socket = new Socket();
		
//		InputStream fis = socket.getInputStream();
//		Reader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr);
//		
//		OutputStream fos = socket.getOutputStream();
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		
		
		//Fluxo de entrada com arquivo
		InputStream fis = System.in; //new FileInputStream("lorem.txt"); -> atraves do arquivo
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		//Fluxo de saida com arquivo
		OutputStream fos = System.out; //new FileOutputStream("lorem3.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String linha = br.readLine();
		
		while (linha != null) {
			bw.write(linha);
			bw.newLine();
			bw.flush(); // System.out
			linha = br.readLine();
		}
				
		br.close();
		bw.close();
	}
	
}
