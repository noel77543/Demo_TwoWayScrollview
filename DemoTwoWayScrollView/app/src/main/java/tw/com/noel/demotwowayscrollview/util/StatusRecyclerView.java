package tw.com.noel.demotwowayscrollview.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
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
    private float downX = 0;
    private float downY = 0;
    private float scrolledX = 0;
    private float scrolledY = 0;

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
                            boxLinearLayoutManager.setScrollEnabled(false);
                        }

                        break;
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                addOnScrollListener(boxCustomScrollListener);
//                downX = ev.getX();
//                downY = ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//
//                scrolledX = Math.abs(downX - ev.getX());
//                scrolledY = Math.abs(downY - ev.getY());
//                double hypotenuse = Math.sqrt(scrolledX * scrolledX + scrolledY * scrolledY);//畢氏定理
//                int angle = Math.round((float) (Math.asin(scrolledY / hypotenuse) / Math.PI * 180));//角度
//
////                if (angle > 45) {
////                    Log.e("滾動", "垂直");
////                    addOnScrollListener(boxCustomScrollListener);
////                } else {
//
//                    if (angle <= 45) {
//                        Log.e("滾動", "水平");
//                        removeOnScrollListener(boxCustomScrollListener);
//                    }
//                    break;
////                }
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//
//
//        return super.dispatchTouchEvent(ev);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downX = ev.getX();
//                downY = ev.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//
//                scrolledX = Math.abs(downX - ev.getX());
//                scrolledY = Math.abs(downY - ev.getY());
//                double hypotenuse = Math.sqrt(scrolledX * scrolledX + scrolledY * scrolledY);//畢氏定理
//                int angle = Math.round((float) (Math.asin(scrolledY / hypotenuse) / Math.PI * 180));//角度
//
//                if (angle > 45) {
//                    Log.e("滾動", "垂直");
//                    addOnScrollListener(boxCustomScrollListener);
//                } else {
//                if (angle <= 45) {
//                    Log.e("滾動", "水平");
//                    removeOnScrollListener(boxCustomScrollListener);
//                }
//                break;
//                }
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//
//
//        return super.onTouchEvent(ev);
//    }


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
