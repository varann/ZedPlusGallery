package zedplus.gallery.dagger;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import zedplus.gallery.client.ApiClient;
import zedplus.gallery.client.ThreeGenresApiClient;

/**
 * Created by asavinova on 18/09/16.
 */
@Module
public class GalleryModule {

	private Class<? extends ApiClient> clientType = ThreeGenresApiClient.class;

	public GalleryModule() {
	}

	@Provides
	public ApiClient client() {
		try {
			return (ApiClient) Class.forName(clientType.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Provides
	@Singleton
	public EventBus eventBus() {
		return EventBus.getDefault();
	}

	public void setClientType(Class<? extends ApiClient> clientType) {
		this.clientType = clientType;
	}

}
