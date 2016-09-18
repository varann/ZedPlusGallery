package zedplus.gallery.client;

import java.util.List;

import zedplus.gallery.client.model.Genre;

/**
 * @author Anna Savinova
 */
public class ManyGenresApiClient extends LinksApiClient {

	@Override
	public List<Genre> getGenres() {
		return genres;
	}

}
