package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ScheduleAdapter extends ArrayAdapter<Schedule> {

    public ScheduleAdapter(@NonNull Context context, List<Schedule> schedules) {
        super(context, 0, schedules);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Schedule schedule = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.schedule_cell, parent, false);
        }

        TextView scheduleCellTV = convertView.findViewById(R.id.scheduleCellTV);

        if (schedule != null) {
            String scheduleTitle = schedule.getName() + " " + CalendarUtils.formattedTime(schedule.getTime());
            scheduleCellTV.setText(scheduleTitle);
        }

        return convertView;
    }
}
