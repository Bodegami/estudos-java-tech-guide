package br.com.bode.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {
		
		//Fluxo de saida com arquivo
		FileOutputStream fos = new FileOutputStream("lorem2.txt");
		Writer osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nulla aliquet porttitor lacus luctus accumsan tortor. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim diam. At volutpat diam ut venenatis tellus in metus. Sed cras ornare arcu dui vivamus arcu felis. Aenean euismod elementum nisi quis. Tortor condimentum lacinia quis vel eros donec. Mattis molestie a iaculis at erat. Mi quis hendrerit dolor magna eget. Maecenas pharetra convallis posuere morbi leo urna molestie. Consequat nisl vel pretium lectus quam id. Sed cras ornare arcu dui.");
		bw.newLine();
		bw.newLine();
		bw.write("hahs huahs heuahs 2");
		
		bw.close();
	}
	
}
