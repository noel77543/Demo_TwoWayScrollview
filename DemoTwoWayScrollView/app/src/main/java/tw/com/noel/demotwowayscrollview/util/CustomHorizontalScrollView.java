package tw.com.noel.demotwowayscrollview.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by noel on 2018/1/11.
 */

public class CustomHorizontalScrollView extends HorizontalScrollView {

    private onScrollViewScrollListener onScrollViewScrollListener = null;

    public CustomHorizontalScrollView(Context context) {
        super(context);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (onScrollViewScrollListener != null) {
            onScrollViewScrollListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public void setOnScrollviewScrollListener(onScrollViewScrollListener onScrollViewScrollListener) {
        this.onScrollViewScrollListener = onScrollViewScrollListener;
    }

    public interface onScrollViewScrollListener {
        void onScrollChanged(CustomHorizontalScrollView scrollView, int x, int y, int oldx, int oldy);
    }

}
