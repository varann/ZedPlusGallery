package zedplus.gallery.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import zedplus.gallery.R;

/**
 * Image view that calculates it size automatically.
 *
 * @author Anna Savinova
 */
public class AspectRatioImageView extends ImageView {

	private float aspectRatio = 1;

	public AspectRatioImageView(Context context) {
		super(context);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public AspectRatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AspectRatio);
		aspectRatio = typedArray.getFloat(R.styleable.AspectRatio_aspectRatio, 1);
		typedArray.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(widthMeasureSpec, (int) (getMeasuredWidth() * aspectRatio));
	}

}
