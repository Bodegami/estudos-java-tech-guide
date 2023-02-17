import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsComLambda {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "editora casa do codigo", "caelum");

		// Utilizando o Consumer como classe anonima
//		palavras.sort(new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				if (s1.length() < s2.length()) {
//					return -1;
//				} else if (s1.length() > s2.length()) {
//					return 1;
//				}
//				return 0;
//			}
//		});

		// Utilizando o lambda - 1º forma (abre um bloco de codigo)
//		palavras.sort((String s1, String s2) -> {
//			if (s1.length() < s2.length()) {
//				return -1;
//			} else if (s1.length() > s2.length()) {
//				return 1;
//			}
//			return 0;
//		});

		// Utilizando o lambda - 2º forma (abre um bloco de codigo)
//		palavras.sort((s1, s2) -> {
//			if (s1.length() < s2.length()) {
//				return -1;
//			} else if (s1.length() > s2.length()) {
//				return 1;
//			}
//			return 0;
//		});

		// Utilizando o lambda - 3º forma (executa apenas uma ação)
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

		// Utilizando o Consumer como classe anonima
//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//				
//			}
//		});

		// Utilizando o lambda - 1º forma (abre um bloco de codigo)
//		palavras.forEach((String s) -> {
//				System.out.println(s);	
//		});

		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
		
		// Utilizando o lambda - 2º forma (executa apenas uma ação)
		palavras.forEach(s -> System.out.println(s));

	}

}
