package zedplus.gallery.dagger;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zedplus.gallery.client.ApiClient;
import zedplus.gallery.client.ManyGenresApiClient;

/**
 * Created by asavinova on 18/09/16.
 */
@Module
public class GalleryModule {

	public GalleryModule() {
	}

	@Provides
	public ApiClient client() {
		return new ManyGenresApiClient();
	}

	@Provides
	@Singleton
	public EventBus eventBus() {
		return EventBus.getDefault();
	}

}
