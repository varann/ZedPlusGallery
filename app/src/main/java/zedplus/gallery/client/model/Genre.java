package zedplus.gallery.client.model;

/**
 * @author Anna Savinova
 */
public class Genre {

	private long id;
	private String name;
	private String image;

	public Genre(long id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
