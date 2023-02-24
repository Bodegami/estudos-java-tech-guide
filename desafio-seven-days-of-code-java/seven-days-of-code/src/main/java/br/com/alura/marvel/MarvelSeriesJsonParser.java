package br.com.alura.marvel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.contracts.JsonParser;

public class MarvelSeriesJsonParser implements JsonParser {
	
	private String json;
	
	public MarvelSeriesJsonParser(String json) {
		this.json = json;
	}

	@Override
	public List<MarvelSeries> parse() {
		Pattern pattern = Pattern.compile("results\":");
		Matcher matcher = pattern.matcher(json);
		
		if(!matcher.find()) {
			throw new IllegalStateException("Results não encontrado");
		}
		
		String substring = this.json.split("results\":")[1];
		String[] jsonSplit = substring.split("null\\},\\{");
		return Stream.of(jsonSplit).map(MarvelSeries::new).collect(Collectors.toList());
	}
	
	public static String getImage(String json) {
		Pattern pattern = Pattern.compile("\"thumbnail\":\\{\"path\":\"");
		Matcher matcher = pattern.matcher(json);
		
		if(!matcher.find()) {
			throw new IllegalStateException("Thumbnail não encontrado");
		}
		
		String imageContent = json.split("\"thumbnail\":\\{\"path\":\"")[1];
		String url = imageContent.split("\",\"extension\":\"")[0];
		String extension = imageContent.split("\",\"extension\":\"")[1].split("\"}")[0];
		String urlImage = String.format("%s.%s", url, extension);
		return urlImage;
	}

}
