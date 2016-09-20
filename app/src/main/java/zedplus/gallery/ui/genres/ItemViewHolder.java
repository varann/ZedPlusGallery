package zedplus.gallery.ui.genres;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zedplus.gallery.R;
import zedplus.gallery.client.model.Genre;
import zedplus.gallery.ui.Images;

/**
 * @author Anna Savinova
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.container) View container;
	@BindView(R.id.image_view) ImageView imageView;
	@BindView(R.id.name_view) TextView nameView;

	private long id;
	private int imageWidth;

	public ItemViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void setGenre(final Genre genre) {
		id = genre.getId();

		Images.load(imageView, genre.getImage());
		nameView.setText(genre.getName());
	}

	public void update(int itemWidth) {
		int padding = itemView.getResources().getDimensionPixelSize(R.dimen.offset_small);
		this.imageWidth = itemWidth - 2 * padding;

		imageView.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, LinearLayout.LayoutParams.WRAP_CONTENT));
	}

	public void setScale(float scale) {
		imageView.setLayoutParams(new LinearLayout.LayoutParams((int) (imageWidth * scale), LinearLayout.LayoutParams.WRAP_CONTENT));
	}

	public long getGenreId() {
		return id;
	}

}
