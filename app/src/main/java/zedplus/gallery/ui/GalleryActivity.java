package zedplus.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import zedplus.gallery.App;
import zedplus.gallery.R;
import zedplus.gallery.client.ApiClient;
import zedplus.gallery.client.model.Genre;
import zedplus.gallery.ui.genres.GenresAdapter;
import zedplus.gallery.ui.genres.GenresRecyclerView;
import zedplus.gallery.ui.genres.OnGenreSelectedEvent;
import zedplus.gallery.ui.movies.MoviesAdapter;
import zedplus.gallery.ui.movies.MoviesRecyclerView;

/**
 * @author Anna Savinova
 */
@EActivity(R.layout.gallery)
public class GalleryActivity extends AppCompatActivity {

	@ViewById GenresRecyclerView genresView;
	@ViewById MoviesRecyclerView moviesView;

	@Inject ApiClient client;
	@Inject EventBus eventBus;

	private GenresAdapter genresAdapter;
	private MoviesAdapter moviesAdapter;
	private LinearLayoutManager moviesLayout;

	@AfterViews
	void afterViews() {
		((App) getApplication()).component().inject(this);

		genresAdapter = new GenresAdapter(this);
		genresView.init(genresAdapter);

		moviesAdapter = new MoviesAdapter(this);
		moviesView.init(moviesAdapter);

		List<Genre> genres = client.getGenres();
		genresAdapter.update(genres);
		moviesAdapter.update(client.getMoviesByGenreId(genres.get(0).getId()));
	}

	@Override
	protected void onResume() {
		super.onResume();
		eventBus.register(this);
	}

	@Override
	protected void onPause() {
		eventBus.unregister(this);
		super.onPause();
	}

	@Subscribe
	public void onGenreChanged(OnGenreSelectedEvent event) {
		moviesAdapter.update(client.getMoviesByGenreId(event.getGenreId()));
	}

}
