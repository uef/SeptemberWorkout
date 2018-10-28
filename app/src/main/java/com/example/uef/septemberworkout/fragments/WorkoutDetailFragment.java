package com.example.uef.septemberworkout.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.model.Workout;
import com.example.uef.septemberworkout.model.WorkoutList;

public class WorkoutDetailFragment extends Fragment {

//    private final String LOGTAG = "WorkoutDetailFragment";

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
    private static final String WORKOUT_INDEX = "WorkoutIndex";

    public static WorkoutDetailFragment initFragment(int workoutIndex){
        WorkoutDetailFragment fragment = new WorkoutDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(WORKOUT_INDEX, workoutIndex);
        fragment.setArguments(arguments);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout_detail, container, false);
        Workout workout = WorkoutList.getInstance().getWorkouts().get(getArguments().getInt(WORKOUT_INDEX));
        initGUI(root, workout);
        addListeners(workout);

        return root;
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d(LOGTAG, LOGTAG + "onStart() ...");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d(LOGTAG, LOGTAG + "onStop() ...");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(LOGTAG, LOGTAG + "onDestroy() ...");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d(LOGTAG, LOGTAG + "onPause() ...");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d(LOGTAG, LOGTAG + "onResume() ...");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d(LOGTAG, LOGTAG + "onRestart() ...");
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle saveInstanceState) {
//        super.onSaveInstanceState(saveInstanceState);
//        saveInstanceState.putInt("repscount", workout.getRecordRepsCount());
//        saveInstanceState.putInt("weight", workout.getRecordWeight());
//        saveInstanceState.putString("date", workout.getFormattedRecordDate());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        workout.setRecordRepsCount(savedInstanceState.getInt("repscount"));
//        workout.setRecordWeight(savedInstanceState.getInt("weight"));
////        workout.setFormattedRecordDate(savedInstanceState.getString("date"));
////        this things for researching...
//
//
//        recordDate = findViewById(R.id.workout_detale_record_date);
//        recordDate.setText(workout.getFormattedRecordDate());
//        recordRepsCount = findViewById(R.id.workout_detale_record_reps_count);
//        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
//        recordWeight = findViewById(R.id.workout_detale_record_weight);
//        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.workout_detail_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_share:
//                shareRecord();
//                return true;
//            case R.id.action_settings:
//                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.action_quit:
//                Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show();
//                onBackPressed();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void shareRecord() {
//        Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, R.string.intent_message);
        sendIntent.setType("text/plain");

        if (sendIntent.resolveActivity(getActivity().getPackageManager()) != null) {
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

    private void initGUI(View view, Workout workout) {
        title = view.findViewById(R.id.workout_detale_title);
        title.setText(workout.getTitle());
        recordDate = view.findViewById(R.id.workout_detale_record_date);
        recordDate.setText(workout.getFormattedRecordDate());
        recordRepsCount = view.findViewById(R.id.workout_detale_record_reps_count);
        recordRepsCount.setText(String.valueOf(workout.getRecordRepsCount()));
        description = view.findViewById(R.id.workout_detale_description);
        description.setText(workout.getDescription());
        recordWeight = view.findViewById(R.id.workout_detale_record_weight);
        recordWeight.setText(String.valueOf(workout.getRecordWeight()));
        weight = view.findViewById(R.id.workout_detale_weight);
        weightSeekBar = view.findViewById(R.id.workout_detale_weight_seekbar);
        repsCountEditText = view.findViewById(R.id.workout_detale_reps_count_edittext);
        saveRecordButton = view.findViewById(R.id.workout_detale_save_button);
//        shareButton = findViewById(R.id.share_button);
    }
}
