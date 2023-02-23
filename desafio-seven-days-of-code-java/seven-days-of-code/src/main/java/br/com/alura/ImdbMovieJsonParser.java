package br.com.alura;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.contracts.JsonParser;

public class ImdbMovieJsonParser implements JsonParser {

	private Matcher matcher;

	public ImdbMovieJsonParser(String json) {
		this.matcher = jsonValidator(json);
	}
	
	private Matcher jsonValidator(String json) {
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("no match in " + json);
		}
		
		return matcher;
	}

	@Override
	public List<Movie> parse() {
		String[] moviesArray = this.matcher.group(1).split("\\},\\{");
		moviesArray[0] = moviesArray[0].substring(1);
		int last = moviesArray.length - 1;
		String lastString = moviesArray[last];
		moviesArray[last] = lastString.substring(0, lastString.length() - 1);
		return Stream.of(moviesArray).map(Movie::new).collect(Collectors.toList());
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

	// SOLUCAO NICO
	private List<String> parseAttribute(String[] movies, int pos) {
		return Stream.of(movies)
				.map(e -> e.split("\",\"")[pos])
				.map(e -> e.split(":\"")[1])
				.map(e -> e.replaceAll("\"", ""))
				.collect(Collectors.toList());
	}

}
