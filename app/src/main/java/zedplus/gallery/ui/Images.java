package zedplus.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * @author Anna Savinova
 */
public class Images {

	public static final float ASPECT_RATIO = 0.635f;

	public static void load(ImageView view, String url) {
		Picasso.with(view.getContext())
				.load(url)
				.transform(new RoundedTransformation(16, 0))
				.fit()
				.into(view);
	}

	private static class RoundedTransformation implements Transformation {

		private int radius;
		private int margin;

		public RoundedTransformation(int radius, int margin) {
			this.radius = radius;
			this.margin = margin;
		}

		@Override
		public Bitmap transform(Bitmap source) {
			final Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,
					Shader.TileMode.CLAMP));

			Bitmap output = Bitmap.createBitmap(source.getWidth(),
					source.getHeight(), Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(output);
			canvas.drawRoundRect(
					new RectF(margin, margin, source.getWidth() - margin, source.getHeight() - margin),
					radius,
					radius,
					paint);

			if (source != output) {
				source.recycle();
			}

			return output;
		}

		@Override
		public String key() {
			return "rounded";
		}
	}

}
