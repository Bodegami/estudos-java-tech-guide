package br.com.alura;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImdbClientAPI {
	
	
	public static String doRequest() throws URISyntaxException, IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(buildUrl())
				.GET()
				.header("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> response = HttpClient.newBuilder()
				.build()
				.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
	
	private static String getApiKey() {
		Optional<String> optionalApikey = Optional.of(System.getenv().get("IMDB_APIKEY"));
		return optionalApikey.orElseThrow();
	}
	
	private static URI buildUrl() throws URISyntaxException {
		String apikey = getApiKey();
		return new URI("https://imdb-api.com/en/API/Top250Movies/" + apikey);
	}
	
	public static String[] parseMovies(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}

		String[] moviesArray = matcher.group(1).split("\\},\\{");
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		return moviesArray;
	}
	
	
	public List<String> parseTitles(String[] arrayMovies) {
		return parseAttribute(arrayMovies, 2);
	}
	
	public List<String> parseUrlImages(String[] arrayMovies) {
		return parseAttribute(arrayMovies, 5);
	}
	
	public List<String> parseRatings(String[] arrayMovies) {
		return parseAttribute(arrayMovies, 7);
	}
	
	public List<String> parseYears(String[] arrayMovies) {
		return parseAttribute(arrayMovies, 4);
	}
	
	//SOLUCAO NICO
	private List<String> parseAttribute(String[] movies, int pos) {
		return Stream.of(movies)
			.map(e -> e.split("\",\"")[pos]) 
			.map(e -> e.split(":\"")[1]) 
			.map(e -> e.replaceAll("\"", ""))
			.collect(Collectors.toList());
	}

}
