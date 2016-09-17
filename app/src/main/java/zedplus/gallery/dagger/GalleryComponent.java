package zedplus.gallery.dagger;

import dagger.Component;
import zedplus.gallery.ui.StartActivity;

/**
 * Created by asavinova on 18/09/16.
 */
@Component(modules = {ClientModule.class})
public interface GalleryComponent {

	void inject(StartActivity x);

}
