package br.com.alura.marvel;

import br.com.alura.contracts.Content;

public class MarvelSeries implements Content {

	private String title;
	private String urlImage;
	private String rating;
	private String year;
	private String type;

	public MarvelSeries(String json) {
		String rating = json.split("rating\":\"")[1].split("\"")[0].trim();
		this.title = json.split("title\":\"")[1].split("\"")[0].trim();
		this.urlImage = MarvelSeriesJsonParser.getImage(json);
		this.rating = (rating.isEmpty()) ? "none" : rating;
		this.year = json.split("startYear\":")[1].split(",")[0].trim();
		this.type = "Series";
	}

	@Override
	public String toString() {
		return "[Title: " + this.title + ", UrlImage: " + this.urlImage + ", Rating: " 
				+ this.rating + ", Year: " + this.year + ", Type: " + this.type + "]";
	}

	@Override
	public String title() {
		return this.title;
	}

	@Override
	public String urlImage() {
		return this.urlImage;
	}

	@Override
	public String rating() {
		return this.rating;
	}

	@Override
	public String year() {
		return this.year;
	}

	@Override
	public int compareTo(Content outro) {
		return this.rating.compareTo(outro.rating());
	}

	@Override
	public String type() {
		return this.type;
	}

}
