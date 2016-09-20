package zedplus.gallery.ui.genres;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

/**
 * @author Anna Savinova
 */
public class GenresRecyclerView extends RecyclerView {

	private GenresAdapter adapter;
	private LinearLayoutManager layoutManager;

	public GenresRecyclerView(Context context) {
		super(context);
	}

	public GenresRecyclerView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public GenresRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void init(GenresAdapter adapter) {
		this.adapter = adapter;
		layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
		setLayoutManager(layoutManager);
		setAdapter(adapter);

		getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				getViewTreeObserver().removeOnGlobalLayoutListener(this);

				int width = getWidth();
				GenresRecyclerView.this.adapter.updateViews(width);
				// Отступ в половину ширины элемента
				int offset = -width / GenresAdapter.VISIBLE_ITEMS_COUNT / 2;
				layoutManager.scrollToPositionWithOffset(GenresRecyclerView.this.adapter.getRealItemCount() - 1, offset);
			}
		});

		addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

				int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
				int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

				int realItemCount = GenresRecyclerView.this.adapter.getRealItemCount();
				if (firstVisibleItemPosition == (2 * realItemCount - 1)) {
					layoutManager.scrollToPosition(realItemCount - 1);
				}

				if (lastVisibleItemPosition == realItemCount) {
					layoutManager.scrollToPosition(2 * realItemCount);
				}

			}
		});
	}

}
