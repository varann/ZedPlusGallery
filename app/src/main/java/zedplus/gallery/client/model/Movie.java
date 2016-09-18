package zedplus.gallery.client.model;

/**
 * @author Anna Savinova
 */
public class Movie {

	private long id;
	private long genreId;
	private String name;
	private String image;

	public Movie(long id, long genreId, String name, String image) {
		this.id = id;
		this.genreId = genreId;
		this.name = name;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
