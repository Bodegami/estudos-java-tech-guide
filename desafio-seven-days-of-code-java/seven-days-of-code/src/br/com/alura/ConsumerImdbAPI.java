package br.com.alura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumerImdbAPI {

	public static void main(String[] args) {
		
		String apikey = args[0];
		
		try {
			
			URI uri = new URI("https://imdb-api.com/en/API/Top250Movies/" + apikey);
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(uri)
					.GET()
					.header("Content-Type", "application/json")
					.build();
			
			HttpResponse<String> response = HttpClient.newBuilder()
					.build()
					.send(request, HttpResponse.BodyHandlers.ofString());
			
			
			System.out.println(response.body().toString());
			
			
		} catch (Exception e) {
			System.out.println("Something is wrong...");
			e.printStackTrace();
		}


	}

}
