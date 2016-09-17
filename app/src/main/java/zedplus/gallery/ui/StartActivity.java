package zedplus.gallery.ui;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import zedplus.gallery.App;
import zedplus.gallery.R;
import zedplus.gallery.client.ApiClient;

/**
 * Created by asavinova on 18/09/16.
 */
@EActivity(R.layout.start)
public class StartActivity extends AppCompatActivity {

	@Inject ApiClient client;

	@AfterViews
	void afterViews() {
		((App) getApplication()).component().inject(this);
	}

}
