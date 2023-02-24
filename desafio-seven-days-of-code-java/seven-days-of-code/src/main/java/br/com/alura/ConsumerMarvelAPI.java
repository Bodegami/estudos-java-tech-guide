package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.contracts.APIClient;
import br.com.alura.contracts.Content;
import br.com.alura.contracts.JsonParser;
import br.com.alura.marvel.MarvelApiClient;
import br.com.alura.marvel.MarvelSeriesJsonParser;
import br.com.alura.utils.HTMLGenerator;

public class ConsumerMarvelAPI {
	
	public static void main(String[] args) {
		
		try {
			APIClient marvelApiClient = new MarvelApiClient("MARVEL_PUBLIC_APIKEY", "MARVEL_PRIVATE_APIKEY");
			String json = marvelApiClient.getBody();
			
			JsonParser jsonParser = new MarvelSeriesJsonParser(json);
			List<? extends Content> marvelSeriesList = jsonParser.parse();
			
			
			System.out.println("\n---------------------------API Marvel Series response: ------------------------------\n");
			System.out.println(json);
			
			
			System.out.println("\n---------------------------List Series Size: ------------------------------\n");
			System.out.println(marvelSeriesList.size());
			
			
			System.out.println("\n---------------------------All Series Parsed: ------------------------------\n");
			marvelSeriesList.forEach(System.out::println);
			
			
			System.out.println("\n---------------------------All Series Titles: ------------------------------\n");
			marvelSeriesList.forEach(ms -> System.out.println(ms.title()));
			
			
			System.out.println("\n---------------------------All Series ResourceURI's: ------------------------------\n");
			marvelSeriesList.forEach(ms -> System.out.println(ms.urlImage()));
			
			
			System.out.println("\n---------------------------All Series Ratings: ------------------------------\n");
			marvelSeriesList.forEach(ms -> System.out.println(ms.rating()));
			
			
			System.out.println("\n---------------------------All Series Years: ------------------------------\n");
			marvelSeriesList.forEach(ms -> System.out.println(ms.year()));
			
			System.out.println("\n-------------------All Series Ratings Natural Order Comparator: -----------------------\n");
			System.out.println("Rating do menor para o maior");
			Collections.sort(marvelSeriesList, Comparator.naturalOrder());
			System.out.println(marvelSeriesList);

			
			System.out.println("\n------------------------All Movies Ratings Reverse Comparator: ---------------------------\n");
			System.out.println("Rating do maior para o menor");
			Collections.sort(marvelSeriesList, Comparator.reverseOrder());
			System.out.println(marvelSeriesList);

			
			System.out.println("\n------------------------All Movies Year Comparing method: ---------------------------\n");
			System.out.println("Rating do maior para o menor");
			Collections.sort(marvelSeriesList, Comparator.comparing(Content::year));
			System.out.println(marvelSeriesList);
			
			
			System.out.println("\n---------------------------Generate template_series_marvel: ------------------------------\n");
			File file = new File("template_series_marvel.html");
			PrintWriter writer = new PrintWriter(file);
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(marvelSeriesList);
			
			writer.close();
			System.out.println("Generate template with success!");
			System.out.println("Path: " + file.getAbsolutePath());

		}
		catch (Exception e) {
			System.out.println("Fail ao consumir api");
		}	
	}
}
