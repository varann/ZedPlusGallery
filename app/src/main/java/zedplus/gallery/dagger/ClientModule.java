package zedplus.gallery.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import zedplus.gallery.client.ApiClient;
import zedplus.gallery.client.ManyGenresApiClient;

/**
 * Created by asavinova on 18/09/16.
 */
@Module
public class ClientModule {

	private Context context;

	public ClientModule(Context context) {
		this.context = context;
	}

	@Provides
	public ApiClient client() {
		return new ManyGenresApiClient();
	}

}
