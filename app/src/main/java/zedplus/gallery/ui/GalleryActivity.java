package zedplus.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import zedplus.gallery.R;
import zedplus.gallery.client.ApiClient;

/**
 * @author Anna Savinova
 */
@EActivity(R.layout.gallery)
public class GalleryActivity extends AppCompatActivity {

	@ViewById RecyclerView genresView;
	@ViewById RecyclerView moviesView;

	@Inject ApiClient client;

	@AfterViews
	void afterViews() {

		genresView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
		moviesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

	}

}
