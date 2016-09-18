package zedplus.gallery;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import zedplus.gallery.client.ApiClient;
import zedplus.gallery.client.ManyGenresApiClient;
import zedplus.gallery.client.model.Genre;
import zedplus.gallery.client.model.Movie;

/**
 * @author Anna Savinova
 */
public class ManyGenresApiTest {

	private ApiClient client = new ManyGenresApiClient();

	@Test
	public void moviesByGenreId() {
		List<Genre> genres = client.getGenres();
		long genreId = genres.get(0).getId();
		List<Movie> moviesByGenre = client.getMoviesByGenreId(genreId);
		Assert.assertTrue("Unexpected size of movies list", !moviesByGenre.isEmpty());
		Assert.assertTrue("Unexpected first movie", "Девятая жизнь Луи Дракса".equals(moviesByGenre.get(0).getName()));
	}

}
