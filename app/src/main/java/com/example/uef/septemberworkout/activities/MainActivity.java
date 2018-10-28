package com.example.uef.septemberworkout.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.uef.septemberworkout.fragments.WorkoutDetailFragment;
import com.example.uef.septemberworkout.fragments.WorkoutListlFragment;
import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.interfaces.OnListItemClickListener;

public class MainActivity extends AppCompatActivity implements OnListItemClickListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutListlFragment listlFragment = new WorkoutListlFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container, listlFragment);
        transaction.commit();
    }

    @Override
    public void onLIstItemClickListener(int index) {
        WorkoutDetailFragment detailFragment = WorkoutDetailFragment.initFragment(index);
        fragmentManager.beginTransaction().
                add(R.id.container, detailFragment)
                .addToBackStack("")
                .commit();
    }
}
