package zedplus.gallery.ui.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zedplus.gallery.R;
import zedplus.gallery.client.model.Movie;
import zedplus.gallery.ui.Images;

/**
 * @author Anna Savinova
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.container) View container;
	@BindView(R.id.image_view) ImageView imageView;
	@BindView(R.id.name_view) TextView nameView;

	public ItemViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void setMovie(Movie movie) {
		Images.load(imageView, movie.getImage());
		nameView.setText(movie.getName());
	}

	public void update(int itemWidth) {
		int height = (int) (itemWidth * Images.ASPECT_RATIO);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(itemWidth, height);
		container.setLayoutParams(params);
	}
}
