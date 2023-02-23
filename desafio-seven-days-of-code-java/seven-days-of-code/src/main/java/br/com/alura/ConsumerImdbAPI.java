package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import br.com.alura.contracts.Content;
import br.com.alura.contracts.JsonParser;

public class ConsumerImdbAPI {

	public static void main(String[] args) {

		try {

			String json = new ImdbApiClient("IMDB_APIKEY").getBody();
			JsonParser jsonParser = new ImdbMovieJsonParser(json);
			List<? extends Content> movies = jsonParser.parse();
			
			System.out.println("\n------------------------API IMDB response:  ---------------------------\n");
			System.out.println(json);
			
			
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
