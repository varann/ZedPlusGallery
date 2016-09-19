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
		holder.setGenre(genres.get(position));
	}

	@Override
	public int getItemCount() {
		return genres.size();
	}

	public void update(List<Genre> genres) {
		this.genres = genres;
		notifyDataSetChanged();
	}

	public void updateViews(int width) {
		itemWidth = width / 6;notifyDataSetChanged();

	}
}
