package tw.com.noel.demotwowayscrollview.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by noel on 2018/1/11.
 */

public class CustomLayoutManager extends LinearLayoutManager{
    private boolean isScrollEnabled = true;

    public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public void setScrollEnabled(boolean isScrollable) {
        this.isScrollEnabled = isScrollable;
    }
    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
