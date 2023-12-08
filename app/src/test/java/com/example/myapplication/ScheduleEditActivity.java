package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;

public class ScheduleEditActivity extends AppCompatActivity {
    private EditText scheduleNameET;
    private TextView scheduleDateTV, scheduleTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_edit);
        initWidgets();
        time = LocalTime.now();
        scheduleDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        scheduleTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
    }

    private void initWidgets() {
        scheduleNameET = findViewById(R.id.scheduleNameET);
        scheduleDateTV = findViewById(R.id.scheduleDateTV);
        scheduleTimeTV = findViewById(R.id.scheduleTimeTV); // Corrected variable name
    }

    public void saveScheduleAction(View view) {
        String scheduleName = scheduleNameET.getText().toString();
        Schedule newSchedule = new Schedule(scheduleName, CalendarUtils.selectedDate, time); // Corrected variable name
        Schedule.scheduleList.add((CharSequence) newSchedule);
        finish();
    }
}