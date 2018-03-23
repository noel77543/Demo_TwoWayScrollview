package tw.noel.sung.com.demo_twowayscrollview.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by noel on 2018/1/10.
 */

public class MemberRecyclerView extends RecyclerView implements RecyclerView.OnItemTouchListener {

    private StatusRecyclerView statusRecyclerview;
    private int lastY;
    private Context context;
    private CustomLayoutManager boxLinearLayoutManager;
    private OnScrollListener onScrollListener;

    public MemberRecyclerView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public MemberRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MemberRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    //------

    /**
     * 起始點
     */
    private void init() {
        initScrollListener();
        boxLinearLayoutManager = new CustomLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        setLayoutManager(boxLinearLayoutManager);

        addOnItemTouchListener(this);
    }


    private void initScrollListener() {
        onScrollListener = new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == recyclerView.SCROLL_STATE_IDLE) {
                    recyclerView.removeOnScrollListener(this);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // member 滾動 status 跟著滾動
                getStatusRecyclerview().scrollBy(dx, dy);
            }
        };
    }



    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        // 當沒在滾動
        if (rv.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
            onTouchEvent(rv, e);
        }
        //return false = > 使事件洩漏到下層 若true則會無法觸發滾動監聽
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (getStatusRecyclerview().getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    // 紀錄另一個列表的y座標並對當前列表addOnScrollListener
                    lastY = recyclerView.getScrollY();
                    recyclerView.addOnScrollListener(onScrollListener);
                }
                boxLinearLayoutManager.setScrollEnabled(true);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (recyclerView.getScrollY() == lastY) {
                    recyclerView.removeOnScrollListener(onScrollListener);
                }
                boxLinearLayoutManager.setScrollEnabled(false);
                break;
        }
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public StatusRecyclerView getStatusRecyclerview() {
        return statusRecyclerview;
    }

    public void setStatusRecyclerview(StatusRecyclerView statusRecyclerview) {
        this.statusRecyclerview = statusRecyclerview;
    }

    public OnScrollListener getBoxCustomScrollListener() {
        return onScrollListener;
    }
}
