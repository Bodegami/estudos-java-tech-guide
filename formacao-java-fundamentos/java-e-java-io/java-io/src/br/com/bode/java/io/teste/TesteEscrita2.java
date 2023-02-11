package br.com.bode.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscrita2 {

	public static void main(String[] args) throws IOException {
		
//		FileOutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
		//FileWriter fw = new FileWriter("lorem4.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem4.txt"));
		
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nulla aliquet porttitor lacus luctus accumsan tortor. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim diam. At volutpat diam ut venenatis tellus in metus. Sed cras ornare arcu dui vivamus arcu felis. Aenean euismod elementum nisi quis. Tortor condimentum lacinia quis vel eros donec. Mattis molestie a iaculis at erat. Mi quis hendrerit dolor magna eget. Maecenas pharetra convallis posuere morbi leo urna molestie. Consequat nisl vel pretium lectus quam id. Sed cras ornare arcu dui.");
		bw.write(System.lineSeparator());
		bw.write(System.lineSeparator());
		bw.write(System.lineSeparator());
		bw.write("hahs huahs heuahs 4");
		
		bw.close();
	}
	
}
