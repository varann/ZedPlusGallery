package zedplus.gallery.ui.genres;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * @author Anna Savinova
 */
public class GenresRecyclerView extends RecyclerView {

	public static final float MAX_SCALE = 1.5f;

	private GenresAdapter adapter;
	private LinearLayoutManager layoutManager;
	private int viewWidth;
	private int itemWidth;

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

				viewWidth = getWidth();
				// Расчет ширины нормального элемента
				itemWidth = (int) (viewWidth / (GenresAdapter.VISIBLE_ITEMS_COUNT - 1 + MAX_SCALE));
				// Отступ в половину ширины элемента
				int offset = -itemWidth / 2;
				GenresRecyclerView.this.adapter.updateViews(itemWidth);
				layoutManager.scrollToPositionWithOffset(GenresRecyclerView.this.adapter.getRealItemCount() - 1, offset);
				// Фиксированная высота с учетом максимального масштаба элемента
				setMinimumHeight((int) (itemWidth * MAX_SCALE));
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

				int centerPosition = Math.round((lastVisibleItemPosition + firstVisibleItemPosition) / 2f);

				View centerView = layoutManager.findViewByPosition(centerPosition);
				ItemViewHolder centerHolder = (ItemViewHolder) recyclerView.findContainingViewHolder(centerView);

				View leftView = layoutManager.findViewByPosition(centerPosition - 1);
				ItemViewHolder leftHolder = (ItemViewHolder) recyclerView.findContainingViewHolder(leftView);

				View rightView = layoutManager.findViewByPosition(centerPosition + 1);
				ItemViewHolder rightHolder = (ItemViewHolder) recyclerView.findContainingViewHolder(rightView);

				float bigItemWidth = itemWidth * MAX_SCALE;
				int leftBound = (int) (viewWidth / 2 - bigItemWidth / 2);
				int rightBound = (int) (viewWidth / 2 + bigItemWidth / 2);
				{
					float diff = Math.abs(leftBound - centerView.getLeft());
					float addScale = diff * (MAX_SCALE - 1) / bigItemWidth;
					if (centerHolder != null) {
						centerHolder.setScale(MAX_SCALE - addScale);
					}
				}
				{
					float diff = leftView.getRight() - leftBound;
					float scale = 1;
					if (diff > 0) {
						scale += diff * (MAX_SCALE - 1) / bigItemWidth;
					}
					if (leftHolder != null) {
						leftHolder.setScale(scale);
					}
				}
				{
					float diff = rightView.getLeft() - rightBound;
					float scale = 1;
					if (diff < 0) {
						scale += -diff * (MAX_SCALE - 1) / bigItemWidth;
					}
					if (rightHolder != null) {
						rightHolder.setScale(scale);
					}
				}

			}
		});

		addItemDecoration(new ItemDecoration() {

			@Override
			public void onDrawOver(Canvas c, RecyclerView parent, State state) {

				int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
				int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

				int centerPosition = Math.round((lastVisibleItemPosition + firstVisibleItemPosition) / 2f);
				View centerView = layoutManager.findViewByPosition(centerPosition);

				c.save();

				Paint frame = new Paint();
				frame.setStrokeWidth(4);
				frame.setStyle(Paint.Style.STROKE);
				frame.setColor(Color.parseColor("#f7a700"));

				int offset = 2;
				RectF rectF = new RectF(centerView.getLeft() - offset,
						centerView.getTop() - offset,
						centerView.getRight() + offset,
						centerView.getBottom() + offset);
				c.drawRoundRect(rectF, 8, 8, frame);

				c.restore();

			}

		});
	}

}
