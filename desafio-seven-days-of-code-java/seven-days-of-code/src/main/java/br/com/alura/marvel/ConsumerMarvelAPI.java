package br.com.alura.marvel;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import br.com.alura.HTMLGenerator;
import br.com.alura.contracts.APIClient;
import br.com.alura.contracts.Content;
import br.com.alura.contracts.JsonParser;

public class ConsumerMarvelAPI {
	
	public static void main(String[] args) {
		
		try {
			APIClient marvelApiClient = new MarvelApiClient("MARVEL_PUBLIC_APIKEY", "MARVEL_PRIVATE_APIKEY");
			String json = marvelApiClient.getBody();
			
			JsonParser jsonParser = new MarvelSerieJsonParser(json);
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
			
			
			System.out.println("\n---------------------------Generate template_series_marvel: ------------------------------\n");
			File file = new File("template_series_marvel.html");
			PrintWriter writer = new PrintWriter(file);
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(marvelSeriesList);
			
			writer.close();
			System.out.println("Generate template with success!");
			System.out.println("Path: " + file.getAbsolutePath());
			
			
//			JsonParser jsonParser = new MarvelSerieJsonParser(json);
//			List<? extends Content> series = jsonParser.parse();
			
//			String substring = json.split("results\":")[1];
//			String[] jsonSplit = substring.split("null\\},\\{");
			
//			List<String> list = Stream.of(jsonSplit)
//				.map(t -> t.split("\",")[0])
//				.map(t -> t.trim())
//				.filter(t -> !t.contains("id\":"))
//				//.forEach(System.out::println);
//				//.map(t -> t.split("\",")[0])
//				.collect(Collectors.toList());
//			System.out.println(list.toString());
//			System.out.println(list.size());
//			System.out.println("JSONsplit main: " + jsonSplit[0]);	
//			System.out.println("Title: " + jsonSplit[0].split("title\":\"")[1].split("\"")[0].trim().toString());	
//			System.out.println("urlImage: " + jsonSplit[0].split("resourceURI\":\"")[1].split("\"")[0].trim().toString());	
//			System.out.println("rating: " + jsonSplit[0].split("rating\":\"")[1].split("\"")[0].trim().toString());	
//			System.out.println("year: " + jsonSplit[0].split("startYear\":")[1].split(",")[0].trim().toString());	
//			MarvelSerie marvelSerie = new MarvelSerie(jsonSplit[0]);
//			System.out.println(marvelSerie);

		}
		catch (Exception e) {
			System.out.println("Fail ao consumir api");
		}
		
	}

}
