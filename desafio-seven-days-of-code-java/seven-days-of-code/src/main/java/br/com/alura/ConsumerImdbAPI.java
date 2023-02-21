package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class ConsumerImdbAPI {

	public static void main(String[] args) {

		try {

			String json = new ImdbApiClient("IMDB_APIKEY").getBody();
			List<Movie> movies = new ImdbMovieJsonParser(json).parseMovies(json);
			
			System.out.printf("Quantidade de filmes: %d\n",movies.size());
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
			
			PrintWriter writer = new PrintWriter(new File("template_movies.html"));
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(movies);
			
			writer.close();

		} catch (Exception e) {
			System.out.println("Something is wrong...");
			e.printStackTrace();
		}

	}

}
