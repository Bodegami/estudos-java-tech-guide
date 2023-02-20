package br.com.alura;

public class Movie {

	private String title;
	private String urlImage;
	private String rating;
	private String year;

	public Movie(String json) {
		String[] movieAttributesJson = json.split("\",\"");
		this.title = movieAttributesJson[2].split(":\"")[1];
		this.urlImage = movieAttributesJson[5].split(":\"")[1];
		this.rating = movieAttributesJson[7].split(":\"")[1];
		this.year = movieAttributesJson[4].split(":\"")[1];
	}

	public String getTitle() {
		return title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public String getRating() {
		return rating;
	}

	public String getYear() {
		return year;
	}
	
	@Override
	public String toString() {
		return "[Title: " + this.title + ", UrlImage: " + this.urlImage 
				+ ", Rating: " + this.rating + ", Year: " + year + "]";
	}

}
