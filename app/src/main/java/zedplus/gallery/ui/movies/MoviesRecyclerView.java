package zedplus.gallery.ui.movies;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import zedplus.gallery.R;

/**
 * @author Anna Savinova
 */
public class MoviesRecyclerView extends RecyclerView {

	private LinearLayoutManager layoutManager;

	public MoviesRecyclerView(Context context) {
		super(context);
	}

	public MoviesRecyclerView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public MoviesRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(final MoviesAdapter adapter) {
		layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
		setLayoutManager(layoutManager);
		setAdapter(adapter);

		getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				getViewTreeObserver().removeOnGlobalLayoutListener(this);
				adapter.updateViews(getWidth() - 2 * getResources().getDimensionPixelOffset(R.dimen.offset_small));
			}
		});
	}

}
