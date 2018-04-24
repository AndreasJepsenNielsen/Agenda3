package com.agenda.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private int Id;
    private String Title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Start_Date;
    private int ECTS;

    public Course() {

    }

    public Course(int id, String title, Date start_Date, int ETCS) {
        Id = id;
        Title = title;
        Start_Date = start_Date;
        this.ECTS = ETCS;
    }

    public int getId() {

        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
}
