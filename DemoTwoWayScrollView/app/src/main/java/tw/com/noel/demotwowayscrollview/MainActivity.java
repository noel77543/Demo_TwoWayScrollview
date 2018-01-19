package tw.com.noel.demotwowayscrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberRecyclerview = findViewById(R.id.recyclerview_member);
        statusRecyclerview = findViewById(R.id.recyclerview_status);

        memberRecyclerview.setStatusRecyclerview(statusRecyclerview);
        statusRecyclerview.setMemberRecyclerView(memberRecyclerview);

        scrollView = findViewById(R.id.scrollView);
        scrollView.setOnScrollviewScrollListener(this);

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

        memberRecyclerview.removeOnScrollListener(memberRecyclerview.getBoxCustomScrollListener());
        statusRecyclerview.removeOnScrollListener(statusRecyclerview.getBoxCustomScrollListener());
    }

}
