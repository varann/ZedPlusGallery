package zedplus.gallery;

import android.app.Application;

import zedplus.gallery.client.ApiClient;
import zedplus.gallery.dagger.GalleryModule;
import zedplus.gallery.dagger.DaggerGalleryComponent;
import zedplus.gallery.dagger.GalleryComponent;

/**
 * Created by asavinova on 18/09/16.
 */
public class App extends Application {

	private GalleryComponent component;
	private GalleryModule galleryModule;

	@Override
	public void onCreate() {
		super.onCreate();

		galleryModule = new GalleryModule();
		component = DaggerGalleryComponent.builder()
				.galleryModule(galleryModule)
				.build();
	}

	public GalleryComponent component() {
		return component;
	}

	public void setClientType(Class<? extends ApiClient> type) {
		galleryModule.setClientType(type);
	}
}
