package br.com.alura.imdb;

import br.com.alura.contracts.Content;

public class Movie implements Content, Comparable<Content> {

	private String title;
	private String urlImage;
	private String rating;
	private String year;
	private String type;

	public Movie(String json) {
		String[] movieAttributesJson = json.split("\",\"");
		this.title = movieAttributesJson[2].split(":\"")[1];
		this.urlImage = movieAttributesJson[5].split(":\"")[1];
		this.rating = movieAttributesJson[7].split(":\"")[1];
		this.year = movieAttributesJson[4].split(":\"")[1];
		this.type = "Movie";
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
	public String type() {
		return this.type;
	}

	@Override
	public int compareTo(Content outro) {
		return this.rating.compareTo(outro.rating());
	}

}
