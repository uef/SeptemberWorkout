package com.example.uef.septemberworkout.fragments;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.interfaces.OnListItemClickListener;
import com.example.uef.septemberworkout.list.WorkoutAdapter;

public class WorkoutListlFragment extends Fragment {

    private static final String TAG = "WorkoutListActivity";
    private OnListItemClickListener listener;

    public void onAttach(Context context) {
        if(context instanceof OnListItemClickListener){
            listener = (OnListItemClickListener) context;
        }
        super.onAttach((Activity) context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout_list, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(container.getContext(), 2);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new WorkoutAdapter(listener));

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "... OnCreate");


    }
}
