package com.example.myapplication;

import android.os.Build;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
   private final ArrayList<String> days;
   public final View parentView;
   public final TextView dayOfMonth;
   private final CalendarAdapter.OnItemListener onItemListener;

   public CalendarViewHolder(@NonNull View itemView, CalendarAdapter.OnItemListener onItemListener, ArrayList<String> days) {
      super(itemView);
      parentView = itemView.findViewById(R.id.parentView);
      dayOfMonth = itemView.findViewById(R.id.cellDayText);
      this.onItemListener = onItemListener;
      this.days = days;
      itemView.setOnClickListener(this);
   }

   @RequiresApi(api = Build.VERSION_CODES.O)
   @Override
   public void onClick(View view) {
      onItemListener.onItemClick(getAdapterPosition(), String.valueOf(dayOfMonth.getText()));
      onItemListener.onItemClick(getAdapterPosition(), days.get(getAdapterPosition()));
   }
}
