package com.example.uef.septemberworkout.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.interfaces.OnListItemClickListener;
import com.example.uef.septemberworkout.model.Workout;
import com.example.uef.septemberworkout.model.WorkoutList;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {
    private List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();
    private OnListItemClickListener itemClickLIstener;

    public WorkoutAdapter(OnListItemClickListener itemClickLIstener){
        this.itemClickLIstener = itemClickLIstener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_item,
                viewGroup,
                false
        );
        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int index) {
        workoutViewHolder.bindView(workoutList.get(index),index, itemClickLIstener);
    }

    @Override
    public int getItemCount() {
        return workoutList != null ? workoutList.size() : 0;
    }

}
