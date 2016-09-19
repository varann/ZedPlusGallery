package zedplus.gallery.ui.genres;

/**
 * @author Anna Savinova
 */
public class OnGenreSelectedEvent {

	private long genreId;

	public OnGenreSelectedEvent(long genreId) {
		this.genreId = genreId;
	}

	public long getGenreId() {
		return genreId;
	}

}
