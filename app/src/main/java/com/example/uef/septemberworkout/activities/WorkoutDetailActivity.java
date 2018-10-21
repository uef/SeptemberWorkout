package com.example.uef.septemberworkout.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.model.Workout;

import java.util.Date;

public class WorkoutDetailActivity extends AppCompatActivity {

    private final String LOGTAG = "WorkoutDetailActivity";

    private TextView title;
    private TextView recordDate;
    private TextView recordRepsCount;
    private TextView description;
    private TextView recordWeight;
    private TextView weight;
    private ImageView image;
    private SeekBar weightSeekBar;
    private EditText repsCountEditText;
    private Button saveRecordButton;
    private Button shareButton;

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
        Log.d(LOGTAG, LOGTAG + "onDestroy() ...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGTAG, LOGTAG + "onPause() ...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGTAG, LOGTAG + "onResume() ...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGTAG, LOGTAG + "onRestart() ...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);
        Workout workout = new Workout("Pull ups", "Pull ups on horizontal bar", 0, new Date(), 0, "");
        initGUI(workout);
        addListeners(workout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.workout_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                shareRecord();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_quit:
                Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show();
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareRecord() {
        Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, R.string.intent_message);
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    private void addListeners(final Workout workout) {
        saveRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!weight.getText().toString().isEmpty()) {
                    if (Integer.parseInt(String.valueOf(weight.getText())) > workout.getRecordWeight()) {
                        recordWeight.setText(weight.getText());
                        workout.setRecordWeight(Integer.parseInt(String.valueOf(weight.getText())));
                    }
                }

                if (!repsCountEditText.getText().toString().isEmpty()) {
                    if (Integer.parseInt(String.valueOf(repsCountEditText.getText())) > workout.getRecordRepsCount()) {
                        recordRepsCount.setText(repsCountEditText.getText());
                        workout.setRecordRepsCount(Integer.parseInt(String.valueOf(repsCountEditText.getText())));
                    }
                }
            }
        });

        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weight.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        shareButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                shareRecord();
//
////                Intent sendIntent = new Intent();
////                sendIntent.setAction(Intent.ACTION_SEND);
////                StringBuilder sb = new StringBuilder();
////                sb.append(workout.getTitle());
////                sb.append(";");
////                sb.append(workout.getFormattedRecordDate());
////                sb.append(";");
////                sb.append(workout.getRecordRepsCount());
////                sb.append(";");
////                sb.append(workout.getRecordWeight());
////
////                sendIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
////                sendIntent.setType("text/plain");
////
////                if (sendIntent.resolveActivity(getPackageManager()) != null) {
////                    startActivity(sendIntent);
////                }
//            }
//        });
    }

    private void initGUI(Workout workout) {
        title = findViewById(R.id.workout_detale_title);
        title.setText(workout.getTitle());
        recordDate = findViewById(R.id.workout_detale_record_date);
        recordDate.setText(workout.getFormattedRecordDate());
        recordRepsCount = findViewById(R.id.workout_detale_record_reps_count);
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        description = findViewById(R.id.workout_detale_description);
        description.setText(workout.getDescription());
        recordWeight = findViewById(R.id.workout_detale_record_weight);
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
        weight = findViewById(R.id.workout_detale_weight);
        weightSeekBar = findViewById(R.id.workout_detale_weight_seekbar);
        repsCountEditText = findViewById(R.id.workout_detale_reps_count_edittext);
        saveRecordButton = findViewById(R.id.workout_detale_save_button);
//        shareButton = findViewById(R.id.share_button);
    }
}
