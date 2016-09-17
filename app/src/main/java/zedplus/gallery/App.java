package zedplus.gallery;

import android.app.Application;

import zedplus.gallery.dagger.ClientModule;
import zedplus.gallery.dagger.DaggerGalleryComponent;
import zedplus.gallery.dagger.GalleryComponent;

/**
 * Created by asavinova on 18/09/16.
 */
public class App extends Application {

	private GalleryComponent component;

	@Override
	public void onCreate() {
		super.onCreate();

		component = DaggerGalleryComponent.builder()
				.clientModule(new ClientModule(this))
				.build();
	}

	public GalleryComponent component() {
		return component;
	}

}
