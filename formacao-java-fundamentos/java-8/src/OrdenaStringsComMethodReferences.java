import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStringsComMethodReferences {

	public static void main(String[] args) {

		List<String> palavras = Arrays.asList("alura online", "editora casa do codigo", "caelum");


		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		System.out.println("Utilizando lambda no metodo comparing do Comparator - forma menos verbosa");
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		
		System.out.println("\n---------------------------------------------");

		
		System.out.println("Utilizando lambda no metodo comparing do Comparator - forma verbosa");
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
		System.out.println(palavras);
		
		
		System.out.println("\n---------------------------------------------");

		
		System.out.println("Utilizando Method References no metodo comparing do Comparator - forma menos verbosa");
		palavras.sort(Comparator.comparing(String::length));
		
		
		System.out.println("\n---------------------------------------------");
		
		
		System.out.println("Criando uma Function com method references");
		Function<String, Integer> funcao2 = String::length;
		Comparator<String> comparador2 = Comparator.comparing(funcao);
		palavras.sort(comparador2);
		
		System.out.println(palavras);
		
		
		System.out.println("\n---------------------------------------------");
		
		
		System.out.println("Utilizando o method references no Consumer");
		Consumer<String> impressor = System.out::println;
		palavras.forEach(impressor);

		
		System.out.println("\n---------------------------------------------");
		
		
		System.out.println("Utilizando o method references no metodo foreach da lista");
		palavras.forEach(System.out::println);

	}

}
