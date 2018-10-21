package com.example.uef.septemberworkout.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uef.septemberworkout.R;

public class WorkoutListlActivity extends AppCompatActivity {

    private final String LOGTAG = "WorkoutListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOGTAG, LOGTAG + "onStart() ...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOGTAG, LOGTAG + "onStop() ...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG,LOGTAG + "onDestroy() ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGTAG,LOGTAG + "onPause() ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG,LOGTAG + "onResume() ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGTAG,LOGTAG + "onRestart() ...");
    }

}
