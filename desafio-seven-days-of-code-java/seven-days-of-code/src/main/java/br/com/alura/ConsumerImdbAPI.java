package br.com.alura;

import java.util.List;

public class ConsumerImdbAPI {

	public static void main(String[] args) {

		try {

			ImdbClientAPI client = new ImdbClientAPI();
			String json = client.doRequest();

//			String substring = json.substring(10);
//			System.out.println(substring);
//			String[] arrayFilmes = substring.split("},");
//			for (int count = 0; count < arrayFilmes.length; count++) {
//				System.out.printf("Posicao %d: %s\n", count, arrayFilmes[count]);
//			}
//			String filme = arrayFilmes[0];
//			String[] filmeAtt = filme.split("\",");
//			for (String att : filmeAtt) {
//				System.out.println(att);
//			}

			String[] parseMovies = client.parseMovies(json);
			List<String> parseTitles = client.parseTitles(parseMovies);
			parseTitles.forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			List<String> parseUrlImages = client.parseUrlImages(parseMovies);
			parseUrlImages.forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			List<String> parseRatings = client.parseRatings(parseMovies);
			parseRatings.forEach(System.out::println);

			System.out.println("\n------------------------END---------------------------\n");

			List<String> parseYears = client.parseYears(parseMovies);
			parseYears.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println("Something is wrong...");
			e.printStackTrace();
		}

	}

}
