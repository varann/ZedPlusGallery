package zedplus.gallery.ui.genres;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import zedplus.gallery.App;
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

	@Inject EventBus eventBus;

	private long id;

	public ItemViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
		((App) itemView.getContext().getApplicationContext()).component().inject(this);

		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				eventBus.post(new OnGenreSelectedEvent(id));
			}
		});
	}

	public void setGenre(final Genre genre) {
		id = genre.getId();

		Images.load(imageView, genre.getImage());
		nameView.setText(genre.getName());
	}

	public void update(int itemWidth) {
		container.setLayoutParams(new ViewGroup.LayoutParams(itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
	}
}
