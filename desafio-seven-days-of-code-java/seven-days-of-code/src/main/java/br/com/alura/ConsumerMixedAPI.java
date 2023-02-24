package br.com.alura;

import java.io.File;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.contracts.Content;
import br.com.alura.imdb.ImdbApiClient;
import br.com.alura.imdb.ImdbMovieJsonParser;
import br.com.alura.marvel.MarvelApiClient;
import br.com.alura.marvel.MarvelSeriesJsonParser;
import br.com.alura.utils.HTMLGenerator;

public class ConsumerMixedAPI {
	
	public static void main(String[] args) {
		
		try {
			
			String jsonMarvelApi = new MarvelApiClient("MARVEL_PUBLIC_APIKEY", "MARVEL_PRIVATE_APIKEY").getBody();
			List<? extends Content> listMarvelContent = new MarvelSeriesJsonParser(jsonMarvelApi).parse();
			
			String jsonImdbApi = new ImdbApiClient("IMDB_APIKEY").getBody();
			List<? extends Content> listImdbContent = new ImdbMovieJsonParser(jsonImdbApi).parse();
			
			List<? extends Content> mixedList = Stream.of(listMarvelContent, listImdbContent)
					.flatMap(Collection::stream)
					.collect(Collectors.toList());
			
			
			System.out.println("\n---------------------------MixedList Size: ------------------------------\n");
			System.out.println(mixedList.size());
			
			
			System.out.println("\n---------------------------All Content Parsed: ------------------------------\n");
			mixedList.forEach(System.out::println);
			
			
			System.out.println("\n------------------------All Movies Title Comparing method: ---------------------------\n");
			System.out.println("Rating do maior para o menor");
			Collections.sort(mixedList, Comparator.comparing(Content::title));
			System.out.println(mixedList);
			
			
			System.out.println("\n---------------------------Generate template_mixed_content: ------------------------------\n");
			File file = new File("template_mixed_content.html");
			PrintWriter writer = new PrintWriter(file);
			HTMLGenerator htmlGenerator = new HTMLGenerator(writer);
			htmlGenerator.generate(mixedList);
			
			writer.close();
			System.out.println("Generate template with success!");
			System.out.println("Path: " + file.getAbsolutePath());
			
		} catch (Exception e) {
			System.out.println("Fail ao consumir api");
		}
		
		
	}

}
