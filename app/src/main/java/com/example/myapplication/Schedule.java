package com.example.myapplication;

import androidx.appcompat.view.menu.MenuBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule
{
    public static ArrayList<Schedule> schedulesList = new ArrayList<>();
    public static MenuBuilder scheduleList;

    public static ArrayList<Schedule> schedulesForDate(LocalDate date)
    {
        ArrayList<Schedule> schedules = new ArrayList<>();

        for(Schedule schedule : schedulesList)
        {
            if(schedule.getDate().equals(date))
                schedules.add(schedule);
        }

        return schedules;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;

    public Schedule(String name, LocalDate date, LocalTime time)
    {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}




