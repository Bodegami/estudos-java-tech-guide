package br.com.bode.java.io.teste;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscrita3 {

	public static void main(String[] args) throws IOException {
		
//		FileOutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem4.txt"));
		
//		PrintStream ps = new PrintStream("lorem5.txt");
		PrintWriter ps = new PrintWriter("lorem5.txt");
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nulla aliquet porttitor lacus luctus accumsan tortor. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim diam. At volutpat diam ut venenatis tellus in metus. Sed cras ornare arcu dui vivamus arcu felis. Aenean euismod elementum nisi quis. Tortor condimentum lacinia quis vel eros donec. Mattis molestie a iaculis at erat. Mi quis hendrerit dolor magna eget. Maecenas pharetra convallis posuere morbi leo urna molestie. Consequat nisl vel pretium lectus quam id. Sed cras ornare arcu dui.");
		ps.println();
		ps.println("hahs huahs heuahs 5 pw");
		
		ps.close();
	}
	
}
