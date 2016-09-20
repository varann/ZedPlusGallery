package zedplus.gallery.client;

import java.util.ArrayList;
import java.util.List;

import zedplus.gallery.client.model.Genre;

/**
 * @author Anna Savinova
 */
public class FourGenresApiClient extends LinksApiClient {

	@Override
	public List<Genre> getGenres() {
		return new ArrayList<>(genres.subList(0, 4));
	}

}
