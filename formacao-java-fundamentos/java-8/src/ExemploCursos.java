import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExemploCursos {
	
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		
		//interface fluente (stream)
		//Stream e collections não são a mesma coisa
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100) //filtra pelos cursos com mais ou igual a 100 alunos
			.map(c -> c.getAlunos()) //cria uma stream de Integer da quantidade de alunos
			.forEach(System.out::println);
		
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100) //filtra pelos cursos com mais ou igual a 100 alunos
			.mapToInt(Curso::getAlunos)
			.sum(); //cria uma stream de Integer da quantidade de alunos
		
		System.out.println(sum);
	}
}
