package zedplus.gallery.client;

import java.util.List;

import zedplus.gallery.client.model.Genre;
import zedplus.gallery.client.model.Movie;

/**
 * @author Anna Savinova
 */
public interface ApiClient {

	List<Genre> getGenres();

	List<Movie> getMoviesByGenreId(long genreId);

}
