package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerImdbAPI {

	public static void main(String[] args) {

		try {

			String request = ImdbClientAPI.doRequest();
			String[] parseMovies = ImdbClientAPI.parseMovies(request);

			List<Movie> movies = Stream.of(parseMovies).map(Movie::new).collect(Collectors.toList());

			System.out.println(movies.size());
			movies.forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			movies.stream().map(m -> m.getTitle()).forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			movies.stream().map(m -> m.getUrlImage()).forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			movies.stream().map(m -> m.getRating()).forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");
			
			movies.stream().map(m -> m.getYear()).forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");
			
			PrintWriter print = new PrintWriter(new File("template_movies.html"));
			HTMLGenerator htmlGenerator = new HTMLGenerator(print);
			htmlGenerator.generate(movies);
			

		} catch (Exception e) {
			System.out.println("Something is wrong...");
			e.printStackTrace();
		}

	}

}
