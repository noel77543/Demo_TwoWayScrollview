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

public class StatusRecyclerView extends RecyclerView {
    private Context context;
    private MyOnScrollListener boxCustomScrollListener;
    private int lastY;

    private MemberRecyclerView memberRecyclerView;
    private CustomLayoutManager boxLinearLayoutManager;

    public StatusRecyclerView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public StatusRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public StatusRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    //------

    /***
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
                getMemberRecyclerView().scrollBy(dx, dy);

            }
        };


        addOnItemTouchListener(new OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // 當沒滾動
                if (rv.getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
                    onTouchEvent(rv, e);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent e) {
                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (getMemberRecyclerView().getScrollState() == RecyclerView.SCROLL_STATE_IDLE) {
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
        });
    }


    //----------

    public MemberRecyclerView getMemberRecyclerView() {
        return memberRecyclerView;
    }

    public void setMemberRecyclerView(MemberRecyclerView memberRecyclerView) {
        this.memberRecyclerView = memberRecyclerView;

    }


    public MyOnScrollListener getBoxCustomScrollListener() {
        return boxCustomScrollListener;
    }

}
