package br.com.alura;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ImdbApiClient {
	
	private String apikey;
	
	public ImdbApiClient(String apikey) {
		this.apikey = getApiKey(apikey);
	}

	public String getBody() throws URISyntaxException, IOException, InterruptedException {
		
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
	
	private String getApiKey(String apikey) {
		Optional<String> optionalApikey = Optional.of(System.getenv().get(apikey));
		return optionalApikey.orElseThrow();
	}
	
	private URI buildUrl() throws URISyntaxException {
		return new URI("https://imdb-api.com/en/API/Top250Movies/" + this.apikey);
	}

}
