package com.example.uef.septemberworkout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.uef.septemberworkout.R;
import com.example.uef.septemberworkout.model.Workout;

import java.util.Date;

public class WorkoutDetailActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);
        Workout workout = new Workout("Подтягивания", "Подтягивания на перекладине", 0, new Date(), 0, "");
        initGUI(workout);
        addListeners(workout);

    }

    private void addListeners(final Workout workout) {
        saveRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!weight.getText().toString().isEmpty())
                    if (Integer.parseInt(String.valueOf(weight.getText())) > workout.getRecordWeight())
                        recordWeight.setText(weight.getText());
                        workout.setRecordWeight(Integer.parseInt(String.valueOf(weight.getText())));

                if (!repsCountEditText.getText().toString().isEmpty())
                    if (Integer.parseInt(String.valueOf(repsCountEditText.getText())) > workout.getRecordRepsCount())
                        recordRepsCount.setText(repsCountEditText.getText());
                        workout.setRecordRepsCount(Integer.parseInt(String.valueOf(repsCountEditText.getText())));
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
    }
}
