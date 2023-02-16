import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = Arrays.asList("alura online", "editora casa do codigo", "caelum");
		
		
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		
		// Forma antes do java 8
//		Collections.sort(palavras, comparador);
//		System.out.println(palavras);
		
		// Nova forma após java 8
		// A partir do Java8 as interfaces podem ter os default methods (metodos concretos)
		palavras.sort(comparador);
		System.out.println(palavras);
		
		// Forma antes do java 8
//		for (String p : palavras) {
//			System.out.println(p);
//		}
		
		// Nova forma após java 8
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
	}
	
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
		
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		else if (s1.length() > s2.length()) {
			return 1;
		}
		
		return 0;
	}
	
}
