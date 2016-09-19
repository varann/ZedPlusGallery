package zedplus.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;

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
import zedplus.gallery.ui.genres.OnGenreSelectedEvent;
import zedplus.gallery.ui.movies.MoviesAdapter;

/**
 * @author Anna Savinova
 */
@EActivity(R.layout.gallery)
public class GalleryActivity extends AppCompatActivity {

	@ViewById RecyclerView genresView;
	@ViewById RecyclerView moviesView;

	@Inject ApiClient client;
	@Inject EventBus eventBus;

	private GenresAdapter genresAdapter;
	private MoviesAdapter moviesAdapter;
	private LinearLayoutManager genresLayout;
	private LinearLayoutManager moviesLayout;

	@AfterViews
	void afterViews() {
		((App) getApplication()).component().inject(this);

		genresLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		genresAdapter = new GenresAdapter(this);
		genresView.setLayoutManager(genresLayout);
		genresView.setAdapter(genresAdapter);

		genresView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				genresView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				genresAdapter.updateViews(genresView.getWidth());
			}
		});

		moviesLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		moviesAdapter = new MoviesAdapter(this);
		moviesView.setLayoutManager(moviesLayout);
		moviesView.setAdapter(moviesAdapter);

		moviesView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				moviesView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				moviesAdapter.updateViews(moviesView.getWidth() - 2 * getResources().getDimensionPixelOffset(R.dimen.offset_small));
			}
		});

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
