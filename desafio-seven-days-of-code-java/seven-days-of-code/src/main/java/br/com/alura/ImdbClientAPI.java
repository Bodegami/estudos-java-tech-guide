package br.com.alura;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImdbClientAPI {

	public String doRequest() throws URISyntaxException, IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().uri(buildUrl()).GET().header("Content-Type", "application/json")
				.build();

		HttpResponse<String> response = HttpClient.newBuilder().build().send(request,
				HttpResponse.BodyHandlers.ofString());

		return response.body();
	}

	private String getApiKey() {
		Optional<String> optionalApikey = Optional.of(System.getenv().get("IMDB_APIKEY"));
		return optionalApikey.orElseThrow();
	}

	private URI buildUrl() throws URISyntaxException {
		String apikey = getApiKey();
		return new URI("https://imdb-api.com/en/API/Top250Movies/" + apikey);
	}

	public String[] parseMovies(String json) {
		String substring = json.substring(10);
		String[] arrayMovies = substring.split("},");
		return arrayMovies;
	}

	public List<String> parseTitles(String[] arrayMovies) {
		List<String> titles = new ArrayList<String>();

		for (int i = 0; i < arrayMovies.length; i++) {
			String[] attributes = arrayMovies[i].split("\",");
			String title = attributes[2].substring(9);
			titles.add(title);
		}

		return titles;
	}

	public List<String> parseUrlImages(String[] arrayMovies) {
		List<String> urlImages = new ArrayList<String>();

		for (int i = 0; i < arrayMovies.length; i++) {
			String[] attributes = arrayMovies[i].split("\",");
			String urlImage = attributes[5].substring(9);
			urlImages.add(urlImage);
		}

		return urlImages;
	}

	public List<String> parseRatings(String[] arrayMovies) {
		List<String> ratings = new ArrayList<String>();

		for (int i = 0; i < arrayMovies.length; i++) {
			String[] attributes = arrayMovies[i].split("\",");
			String rating = attributes[7].substring(14);
			ratings.add(rating);
		}

		return ratings;
	}

	public List<String> parseYears(String[] arrayMovies) {
		List<String> years = new ArrayList<String>();

		for (int i = 0; i < arrayMovies.length; i++) {
			String[] attributes = arrayMovies[i].split("\",");
			String year = attributes[4].substring(8);
			years.add(year);
		}

		return years;
	}

}
