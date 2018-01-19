package tw.com.noel.demotwowayscrollview.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import tw.com.noel.demotwowayscrollview.implement.MyOnScrollListener;

/**
 * Created by noel on 2018/1/10.
 */

public class MemberRecyclerView extends RecyclerView implements RecyclerView.OnItemTouchListener {

    private MyOnScrollListener boxCustomScrollListener;
    private StatusRecyclerView statusRecyclerview;
    private int lastY;
    private Context context;
    private CustomLayoutManager boxLinearLayoutManager;

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
        boxLinearLayoutManager = new CustomLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        setLayoutManager(boxLinearLayoutManager);

        boxCustomScrollListener = new MyOnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // member 滾動 status 跟著滾動
                getStatusRecyclerview().scrollBy(dx, dy);

            }
        };

        addOnItemTouchListener(this);
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
                    recyclerView.addOnScrollListener(boxCustomScrollListener);
                }
                boxLinearLayoutManager.setScrollEnabled(true);
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (recyclerView.getScrollY() == lastY) {
                    recyclerView.removeOnScrollListener(boxCustomScrollListener);
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

    public MyOnScrollListener getBoxCustomScrollListener() {
        return boxCustomScrollListener;
    }
}
