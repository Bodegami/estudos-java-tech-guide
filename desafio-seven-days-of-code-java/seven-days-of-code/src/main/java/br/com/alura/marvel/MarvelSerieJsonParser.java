package br.com.alura.marvel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.alura.contracts.JsonParser;

public class MarvelSerieJsonParser implements JsonParser {
	
	private String json;
	
	public MarvelSerieJsonParser(String json) {
		this.json = json;
	}

	@Override
	public List<MarvelSerie> parse() {
		String substring = this.json.split("results\":")[1];
		String[] jsonSplit = substring.split("null\\},\\{");
		return Stream.of(jsonSplit).map(MarvelSerie::new).collect(Collectors.toList());
	}
	
//	private Matcher jsonValidator(String json) {
//		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);
//
//		if (!matcher.matches()) {
//			throw new IllegalArgumentException("no match in " + json);
//		}
//		
//		return matcher;
//	}
//	

}