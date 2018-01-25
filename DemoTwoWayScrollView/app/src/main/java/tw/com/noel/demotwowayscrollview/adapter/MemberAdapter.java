package tw.com.noel.demotwowayscrollview.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.com.noel.demotwowayscrollview.R;
import tw.com.noel.demotwowayscrollview.model.Box;

/**
 * Created by noel on 2018/1/11.
 */

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Box> boxes;

    public MemberAdapter(Context context) {
        this.context = context;
        boxes = new ArrayList<>();
    }

    public void setData(ArrayList<Box> boxes) {
        this.boxes = boxes;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_box_member, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.textView.setText(boxes.get(position).getName());
        viewHolder.layout.setBackgroundColor(context.getResources().getColor(position % 2 == 0 ? R.color.type_1 : R.color.type_2));

    }

    @Override
    public int getItemCount() {
        return boxes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.layout)
        LinearLayout layout;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
