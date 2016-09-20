package zedplus.gallery.ui.genres;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zedplus.gallery.R;
import zedplus.gallery.client.model.Genre;

/**
 * @author Anna Savinova
 */
public class GenresAdapter extends RecyclerView.Adapter<ItemViewHolder> {

	public static final int VISIBLE_ITEMS_COUNT = 6;

	private final LayoutInflater inflater;
	private List<Genre> genres = new ArrayList<>();
	private int itemWidth;

	public GenresAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.genres_item_view, parent, false);
		return new ItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ItemViewHolder holder, int position) {
		holder.update(itemWidth);

		position = genres.size() == 0 ? 0 : position % genres.size();
		holder.setGenre(genres.get(position));
	}

	@Override
	public int getItemCount() {
		return genres.size() * 3;
	}

	public int getRealItemCount() {
		return genres.size();
	}

	public void update(List<Genre> genres) {
		this.genres.clear();

		int size = genres.size();
		boolean needExtend = size / VISIBLE_ITEMS_COUNT < 1;
		if (needExtend) {
			int duplicateCount = VISIBLE_ITEMS_COUNT % size == 0 ? VISIBLE_ITEMS_COUNT / size : VISIBLE_ITEMS_COUNT / size + 1;
			for (int i = 0; i < duplicateCount; i++) {
				this.genres.addAll(genres);
			}
		} else {
			this.genres = genres;
		}

		notifyDataSetChanged();
	}

	public void updateViews(int width) {
		itemWidth = width;
		notifyDataSetChanged();
	}

}
