package com.example.uef.septemberworkout.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.list.WorkoutAdapter;
import com.example.uef.septemberworkout.model.Workout;
import com.example.uef.septemberworkout.model.WorkoutList;

import org.w3c.dom.Text;

import java.util.List;

public class WorkoutListlActivity extends AppCompatActivity {

    private static final String TAG = "WorkoutListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "... OnCreate");
        setContentView(R.layout.activity_workout_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new WorkoutAdapter());
    }
}
