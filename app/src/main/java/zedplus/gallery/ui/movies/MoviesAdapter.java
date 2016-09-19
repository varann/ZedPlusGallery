package zedplus.gallery.ui.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zedplus.gallery.R;
import zedplus.gallery.client.model.Movie;

/**
 * @author Anna Savinova
 */
public class MoviesAdapter extends RecyclerView.Adapter<ItemViewHolder> {

	private final LayoutInflater inflater;
	private List<Movie> movies = new ArrayList<>();
	private int itemWidth;

	public MoviesAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.movies_item_view, parent, false);
		return new ItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ItemViewHolder holder, int position) {
		holder.update(itemWidth);
		holder.setMovie(movies.get(position));
	}

	@Override
	public int getItemCount() {
		return movies.size();
	}

	public void update(List<Movie> movies) {
		this.movies = movies;
		notifyDataSetChanged();
	}

	public void updateViews(int width) {
		// Округляем в большую сторону
		itemWidth = width / 3 + 1;
		notifyDataSetChanged();
	}


}
