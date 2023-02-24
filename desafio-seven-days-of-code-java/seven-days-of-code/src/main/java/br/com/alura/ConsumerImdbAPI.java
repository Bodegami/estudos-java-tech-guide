package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.contracts.JsonParser;
import br.com.alura.imdb.ImdbApiClient;
import br.com.alura.imdb.ImdbMovieJsonParser;
import br.com.alura.imdb.Movie;
import br.com.alura.utils.HTMLGenerator;

public class ConsumerImdbAPI {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {

			String json = new ImdbApiClient("IMDB_APIKEY").getBody();
			JsonParser jsonParser = new ImdbMovieJsonParser(json);
			List<Movie> movies = (List<Movie>) jsonParser.parse();
			
			System.out.println("\n------------------------API IMDB response:  ---------------------------\n");
			System.out.println(json.toString());
			
			
			System.out.println("\n------------------------List Movies Size:  ---------------------------\n");
			System.out.println(movies.size());

			
			System.out.println("\n------------------------All Movies:  ---------------------------\n");
			movies.forEach(System.out::println);

			
			System.out.println("\n------------------------All Movies Titles: ---------------------------\n");
			movies.stream().map(m -> m.title()).forEach(System.out::println);

			
			System.out.println("\n------------------------All Movies UrlImages: ---------------------------\n");
			movies.stream().map(m -> m.urlImage()).forEach(System.out::println);

			
			System.out.println("\n------------------------All Movies Ratings: ---------------------------\n");
			movies.stream().map(m -> m.rating()).forEach(System.out::println);

			
			System.out.println("\n------------------------All Movies Years: ---------------------------\n");
			movies.stream().map(m -> m.year()).forEach(System.out::println);

			
			System.out.println("\n------------------------All Movies Ratings Natural Order Comparator: ---------------------------\n");
			System.out.println("Rating do menor para o maior");
			Collections.sort(movies);
			System.out.println(movies);

			
			System.out.println("\n------------------------All Movies Ratings Reverse Comparator: ---------------------------\n");
			System.out.println("Rating do maior para o menor");
			Collections.sort(movies, Comparator.reverseOrder());
			System.out.println(movies);

			
			System.out.println("\n------------------------All Movies Year Comparing method: ---------------------------\n");
			System.out.println("Rating do maior para o menor");
			Collections.sort(movies, Comparator.comparing(Movie::year));
			System.out.println(movies);

			
			System.out.println("\n------------------------Generate template_movies---------------------------\n");
			File file = new File("template_movies.html");
			PrintWriter writer = new PrintWriter(file);
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(movies);
			
			writer.close();
			
			System.out.println("Generate template with success!");
			System.out.println("Path: " + file.getAbsolutePath());

		} catch (Exception e) {
			System.out.println("Something is wrong...");
			e.printStackTrace();
		}

	}

}
