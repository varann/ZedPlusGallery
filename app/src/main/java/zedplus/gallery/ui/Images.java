package zedplus.gallery.ui;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author Anna Savinova
 */
public class Images {

	public static final float ASPECT_RATIO = 0.635f;

	public static void load(ImageView view, String url) {
		Picasso.with(view.getContext())
				.load(url)
				.fit()
				.centerInside()
				.into(view);
	}

}
