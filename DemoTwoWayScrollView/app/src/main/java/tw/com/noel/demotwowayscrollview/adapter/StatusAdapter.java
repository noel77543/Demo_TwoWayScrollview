package tw.com.noel.demotwowayscrollview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import tw.com.noel.demotwowayscrollview.R;
import tw.com.noel.demotwowayscrollview.model.Box;

/**
 * Created by noel on 2018/1/11.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Box> boxes;

    public StatusAdapter(Context context) {
        this.context = context;
        boxes = new ArrayList<>();
    }

    public void setData(ArrayList<Box> boxes) {
        this.boxes = boxes;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_box_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Box box = boxes.get(position);
        viewHolder.layout.setBackgroundColor(context.getResources().getColor(position % 2 == 0 ? R.color.type_1 : R.color.type_2));
        viewHolder.tvPosition.setText(box.getPosition());
        viewHolder.tvTime.setText(box.getTime());
        viewHolder.tvGrades.setText(box.getGrades());
        viewHolder.tvRebound.setText(box.getRebound());
        viewHolder.tvAssits.setText(box.getAssits());
        viewHolder.tvSteals.setText(box.getSteals());
        viewHolder.tvBlock.setText(box.getBlock());
        viewHolder.tvBlocked.setText(box.getBlocked());
        viewHolder.tvShootingSuccess.setText(box.getShootingSuccess());
        viewHolder.tvShootingTotal.setText(box.getShootingTotal());
        viewHolder.tvShootingPercentage.setText(box.getShootingPercentage());
        viewHolder.tvThreeGradesSuccess.setText(box.getThreeGradesSuccess());
        viewHolder.tvThreeGradesTotal.setText(box.getThreeGradesTotal());
        viewHolder.tvThreeGradesPercentage.setText(box.getThreeGradesPercentage());
        viewHolder.tvPenaltyShotSuccess.setText(box.getPenaltyShotSuccess());
        viewHolder.tvPenaltyShotTotal.setText(box.getPenaltyShotTotal());
        viewHolder.tvPenaltyShotPercentage.setText(box.getPenaltyShotPercentage());


    }

    @Override
    public int getItemCount() {
        return boxes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tvPosition;
        private TextView tvTime;
        private TextView tvGrades;
        private TextView tvRebound;
        private TextView tvAssits;
        private TextView tvSteals;
        private TextView tvBlock;
        private TextView tvBlocked;
        private TextView tvShootingSuccess;
        private TextView tvShootingTotal;
        private TextView tvShootingPercentage;
        private TextView tvThreeGradesSuccess;
        private TextView tvThreeGradesTotal;
        private TextView tvThreeGradesPercentage;
        private TextView tvPenaltyShotSuccess;
        private TextView tvPenaltyShotTotal;
        private TextView tvPenaltyShotPercentage;
        private LinearLayout layout;

        public ViewHolder(View view) {
            super(view);
            this.tvPosition = view.findViewById(R.id.tv_position);
            this.tvTime = view.findViewById(R.id.tv_time);
            this.tvGrades = view.findViewById(R.id.tv_grades);
            this.tvRebound = view.findViewById(R.id.tv_rebound);
            this.tvAssits = view.findViewById(R.id.tv_assits);
            this.tvSteals = view.findViewById(R.id.tv_steals);
            this.tvBlock = view.findViewById(R.id.tv_block);
            this.tvBlocked = view.findViewById(R.id.tv_blocked);
            this.tvShootingSuccess = view.findViewById(R.id.tv_shooting_success);
            this.tvShootingTotal = view.findViewById(R.id.tv_shooting_total);
            this.tvShootingPercentage = view.findViewById(R.id.tv_shooting_percentage);
            this.tvThreeGradesSuccess = view.findViewById(R.id.tv_three_grades_success);
            this.tvThreeGradesTotal = view.findViewById(R.id.tv_three_grades_total);
            this.tvThreeGradesPercentage = view.findViewById(R.id.tv_three_grades_percentage);
            this.tvPenaltyShotSuccess = view.findViewById(R.id.tv_penalty_shot_success);
            this.tvPenaltyShotTotal = view.findViewById(R.id.tv_penalty_shot_total);
            this.tvPenaltyShotPercentage = view.findViewById(R.id.tv_penalty_shot_percentage);
            this.layout = view.findViewById(R.id.layout);

        }
    }
}
