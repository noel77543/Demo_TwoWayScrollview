package tw.com.noel.demotwowayscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import java.util.ArrayList;

import tw.com.noel.demotwowayscrollview.adapter.MemberAdapter;
import tw.com.noel.demotwowayscrollview.adapter.StatusAdapter;
import tw.com.noel.demotwowayscrollview.implement.MyOnScrollListener;
import tw.com.noel.demotwowayscrollview.model.Box;
import tw.com.noel.demotwowayscrollview.util.CustomHorizontalScrollView;
import tw.com.noel.demotwowayscrollview.util.MemberRecyclerView;
import tw.com.noel.demotwowayscrollview.util.StatusRecyclerView;

public class MainActivity extends AppCompatActivity implements CustomHorizontalScrollView.onScrollViewScrollListener {

    private StatusAdapter statusAdapter;
    private MemberAdapter memberAdapter;

    private ArrayList<Box> boxes;
    private MemberRecyclerView memberRecyclerview;
    private StatusRecyclerView statusRecyclerview;
    private CustomHorizontalScrollView scrollView;

    private float downX = 0;
    private float downY = 0;

    private float scrollX = 0;
    private float scrollY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberRecyclerview = findViewById(R.id.recyclerview_member);
        statusRecyclerview = findViewById(R.id.recyclerview_status);
        scrollView = findViewById(R.id.scrollView);

        memberRecyclerview.setStatusRecyclerview(statusRecyclerview);
        statusRecyclerview.setMemberRecyclerView(memberRecyclerview);

        scrollView.setOnScrollviewScrollListener(this);
        scrollView.setStatusRecyclerView(statusRecyclerview);

        statusAdapter = new StatusAdapter(this);
        memberAdapter = new MemberAdapter(this);


        memberRecyclerview.setAdapter(memberAdapter);
        statusRecyclerview.setAdapter(statusAdapter);

        addData();

    }



    //---
    // for test
    private void addData() {
        String[] data = getResources().getStringArray(R.array.data);
        boxes = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            boxes.add(new Box(data[i], "", "10", "100", "10", "10", "10"
                    , "10", "10", "10", "10", "100%", "100", "100"
                    , "100%", "100", "100", "100%"));

        }
        memberAdapter.setData(boxes);
        statusAdapter.setData(boxes);
    }

    @Override
    public void onScrollChanged(CustomHorizontalScrollView scrollView, int x, int y, int oldx, int oldy) {

        Log.e("x",""+x);
        Log.e("y",""+y);
        Log.e("oldx",""+oldx);
        Log.e("oldy",""+oldy);




//
//        memberRecyclerview.removeOnScrollListener(memberRecyclerview.getBoxCustomScrollListener());
        statusRecyclerview.removeOnScrollListener(statusRecyclerview.getBoxCustomScrollListener());
    }

}
