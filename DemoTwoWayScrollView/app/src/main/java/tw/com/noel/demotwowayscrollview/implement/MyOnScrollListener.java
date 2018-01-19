package tw.com.noel.demotwowayscrollview.implement;

import android.support.v7.widget.RecyclerView;

/**
 * Created by noel on 2018/1/11.
 */

public class MyOnScrollListener extends RecyclerView.OnScrollListener {
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == recyclerView.SCROLL_STATE_IDLE) {
            recyclerView.removeOnScrollListener(this);
        }
    }
}
