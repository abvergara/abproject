package com.example.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {
    private final ArrayList<String> days; // Use List<LocalDate> instead of int
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<String> days, OnItemListener onItemListener) { // Use List<LocalDate> instead of int
        this.days = days;
        this.onItemListener = onItemListener;
    }

    public CalendarAdapter(int days, WeekViewActivity onItemListener, ArrayList<String> days1, OnItemListener onItemListener1) {
        this.days = days1;

        this.onItemListener = onItemListener1;
    }

    public CalendarAdapter(int days, WeekViewActivity onItemListener, Object o, OnItemListener onItemListener1, ArrayList<String> days1, OnItemListener onItemListener2) {
        this.days = days1;
        this.onItemListener = onItemListener2;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);

        // Remove this block as it's unnecessary
        // ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        // if (days.size() > 15) {
        //     layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        // } else {
        //     layoutParams.height = (int) parent.getHeight();
        // }

        return new CalendarViewHolder(view, onItemListener, days);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        final String date = days.get(position);

        if (date == null) {
            holder.dayOfMonth.setText("");
        } else {
            holder.dayOfMonth.setText(String.valueOf(date. toString()));
            if (date.equals(CalendarUtils.selectedDate)) {
                holder.parentView.setBackgroundColor(Color.LTGRAY);
            }
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface OnItemListener {
        void onItemClick(int position, LocalDate date);

        @RequiresApi(api = Build.VERSION_CODES.O)
        void onItemClick(int position, String dayText);
    }
}
