package tw.com.noel.demotwowayscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.com.noel.demotwowayscrollview.adapter.MemberAdapter;
import tw.com.noel.demotwowayscrollview.adapter.StatusAdapter;
import tw.com.noel.demotwowayscrollview.model.Box;
import tw.com.noel.demotwowayscrollview.util.CustomHorizontalScrollView;
import tw.com.noel.demotwowayscrollview.util.MemberRecyclerView;
import tw.com.noel.demotwowayscrollview.util.StatusRecyclerView;

public class MainActivity extends AppCompatActivity implements CustomHorizontalScrollView.onScrollViewScrollListener {

    @BindView(R.id.recyclerview_member)
    MemberRecyclerView memberRecyclerview;
    @BindView(R.id.recyclerview_status)
    StatusRecyclerView statusRecyclerview;
    @BindView(R.id.scrollView)
    CustomHorizontalScrollView scrollView;

    private StatusAdapter statusAdapter;
    private MemberAdapter memberAdapter;

    private ArrayList<Box> boxes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




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

        Log.e("x", "" + x);
        Log.e("y", "" + y);
        Log.e("oldx", "" + oldx);
        Log.e("oldy", "" + oldy);


//
//        memberRecyclerview.removeOnScrollListener(memberRecyclerview.getBoxCustomScrollListener());
        statusRecyclerview.removeOnScrollListener(statusRecyclerview.getBoxCustomScrollListener());
    }

}
