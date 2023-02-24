package br.com.alura.imdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import br.com.alura.contracts.APIClient;

public class ImdbApiClient implements APIClient {
	
	private String apikey;
	
	public ImdbApiClient(String apikey) {
		this.apikey = getApiKey(apikey);
	}

	public String getBody() {
		
		try {
			
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
		catch (Exception e) {
			throw new RuntimeException("Falha ao chamar a API...");
		}
		
	}
	
	private String getApiKey(String apikey) {
		Optional<String> optionalApikey = Optional.of(System.getenv().get(apikey));
		return optionalApikey.orElseThrow();
	}
	
	private URI buildUrl() throws URISyntaxException {
		return new URI("https://imdb-api.com/en/API/Top250Movies/" + this.apikey);
	}

}
