package tw.com.noel.demotwowayscrollview.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by noel on 2018/1/11.
 */

public class CustomHorizontalScrollView extends HorizontalScrollView {


    private onScrollViewScrollListener onScrollViewScrollListener = null;
    private StatusRecyclerView statusRecyclerView;


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

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        
        getStatusRecyclerView().removeOnScrollListener(getStatusRecyclerView().getBoxCustomScrollListener());
    }

    public StatusRecyclerView getStatusRecyclerView() {
        return statusRecyclerView;
    }

    public void setStatusRecyclerView(StatusRecyclerView statusRecyclerView) {
        this.statusRecyclerView = statusRecyclerView;
    }
}
