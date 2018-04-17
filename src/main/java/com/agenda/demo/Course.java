package com.agenda.demo;

import java.util.Date;

public class Course {
    private int Id;
    private String Title;
    private Date Start_Date;
    private int ETCS;

    public Course(int id, String title, Date start_Date, int ETCS) {
        Id = id;
        Title = title;
        Start_Date = start_Date;
        this.ETCS = ETCS;
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

    public int getETCS() {
        return ETCS;
    }

    public void setETCS(int ETCS) {
        this.ETCS = ETCS;
    }
}
