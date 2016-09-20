package zedplus.gallery.client;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import zedplus.gallery.R;
import zedplus.gallery.client.model.Genre;
import zedplus.gallery.client.model.Movie;

/**
 * @author Anna Savinova
 */
public interface ApiClient {

	List<Genre> getGenres();

	List<Movie> getMoviesByGenreId(long genreId);

	class Implementations {

		private static Map<Class<? extends ApiClient>, Integer> clientsMap = new LinkedHashMap<>();

		static {
			clientsMap.put(OneGenreApiClient.class, R.string.one_genre);
			clientsMap.put(ThreeGenresApiClient.class, R.string.three_genres);
			clientsMap.put(FourGenresApiClient.class, R.string.four_genres);
			clientsMap.put(ManyGenresApiClient.class, R.string.many_genres);
		}

		public static Map<Class<? extends ApiClient>, Integer> getClients() {
			return Collections.unmodifiableMap(clientsMap);
		}
	}

}
