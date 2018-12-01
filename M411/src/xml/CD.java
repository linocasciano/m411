package xml;

public class CD {
	
	String title = null;
	String country = null;
	String artist = null;
	Integer year = null;
	
	
	
	public CD(String title, String country, String artist, Integer year) {
		super();
		this.title = title;
		this.country = country;
		this.artist = artist;
		this.year = year;
	}
	
	public CD() {
		// explain why
		super();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "CD [title=" + title + ", country=" + country + ", artist=" + artist + ", year=" + year + "]";
	}
	

}
