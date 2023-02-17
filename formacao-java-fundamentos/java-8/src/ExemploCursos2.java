import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ExemploCursos2 {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAlunos));

		System.out.println("Filtra os cursos mais ou igual a 100 alunos, cria um stream de int e faz a soma do total");
		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
		System.out.println(sum);
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Utilizando o Optional");
		Optional<Curso> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 200)
			.findAny();
		
		// Lanca NullPointer caso não tenha o elemento
		//Curso curso = optionalCurso.orElseGet(null);
		//System.out.println(curso.getNome());
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("concatenando metodos da API de stream");
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 200)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Conhecendo a classe OptionalDouble");
		
		OptionalDouble media = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.average();
		
		System.out.println("OptionalDouble isEmpty(): " + media.isEmpty());
		media.ifPresent(m -> System.out.println("OptionalDouble ifPresent()"));
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Utilizando a API de streams em uma lista e retornando uma nova lista");
		
		List<Curso> resultado = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		resultado.forEach(c -> System.out.println(c.getNome()));
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Filtrando por cursos com mais de 100 alunos e transformando num Map");
		
		Map<String, Integer> mapa = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), //define a Key
					c -> c.getAlunos())); //define o Value	

		System.out.println(mapa);
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Filtrando por cursos com mais de 100 alunos, transformando num Map e imprimindo");
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), //define a Key
					c -> c.getAlunos())) //define o Value
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
		
		System.out.println("\n----------------------------------------------");

		
		System.out.println("Utilizando ParallelStream para Paralelismo de threads");
		
		cursos.parallelStream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), //define a Key
					c -> c.getAlunos())) //define o Value
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		

	}
}
