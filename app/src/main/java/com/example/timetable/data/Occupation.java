package com.example.timetable.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "occupation")
public class Occupation {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String startTime;
    private String endTime;
    private String teacher;
    private String place;
    private String description;
    private int weekDay;

    public int getId() {
        return id;
    }

    public Occupation(int id , String name, String startTime, String endTime, String teacher, String place, String description, int weekDay) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.place = place;
        this.description = description;
        this.weekDay = weekDay;
    }

    @Ignore
    public Occupation(String name, String startTime, String endTime, String teacher, String place, String description, int weekDay) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.place = place;
        this.description = description;
        this.weekDay = weekDay;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public int getWeekDay() {
        return weekDay;
    }
}
