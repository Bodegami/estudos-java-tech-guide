package br.com.alura.marvel;

import br.com.alura.contracts.Content;

public class MarvelSerie implements Content {

	private String title;
	private String urlImage;
	private String rating;
	private String year;

	public MarvelSerie(String json) {
		this.title = json.split("title\":\"")[1].split("\"")[0].trim();
		this.urlImage = json.split("resourceURI\":\"")[1].split("\"")[0].trim();
		this.rating = json.split("rating\":\"")[1].split("\"")[0].trim();
		this.year = json.split("startYear\":")[1].split(",")[0].trim();
	}

	@Override
	public String toString() {
		return "[Title: " + this.title + ", UrlImage: " + this.urlImage 
				+ ", Rating: " + this.rating + ", Year: " + this.year + "]";
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
		return (this.rating.isEmpty()) ? null : this.rating;
	}

	@Override
	public String year() {
		return this.year;
	}

}
