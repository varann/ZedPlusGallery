package zedplus.gallery.dagger;

import javax.inject.Singleton;

import dagger.Component;
import zedplus.gallery.ui.GalleryActivity;
import zedplus.gallery.ui.StartActivity;
import zedplus.gallery.ui.genres.GenresRecyclerView;

/**
 * Created by asavinova on 18/09/16.
 */
@Singleton
@Component(modules = {GalleryModule.class})
public interface GalleryComponent {

	void inject(StartActivity x);

	void inject(GalleryActivity x);

	void inject(GenresRecyclerView x);

}
