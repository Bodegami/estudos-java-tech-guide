package br.com.alura.marvel;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import br.com.alura.contracts.APIClient;

public class MarvelApiClient implements APIClient {
	
	private String publicApikey;
	private String privateApikey;
	
	public MarvelApiClient(String publicApikey, String privateApikey) {
		this.publicApikey = getApiKey(publicApikey);
		this.privateApikey = getApiKey(privateApikey);
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
	
	private URI buildUrl() throws URISyntaxException, NoSuchAlgorithmException {
		long timestamp = System.currentTimeMillis();
		String hashMd5 = HashUtils.getHashMd5(timestamp + this.privateApikey + this.publicApikey);
		
		return new URI("https://gateway.marvel.com:443/v1/public/series?ts=" + timestamp + "&apikey=" + this.publicApikey + "&hash=" + hashMd5);
	}
}
