package com.agenda.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date enrollmentDate;
    private int cpr;

    public Student()
    {

    }

    public Student(int studentId, String firstName, String lastName, java.util.Date enrollmentDate, int cpr) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.cpr = cpr;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.util.Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(java.util.Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public String getDateString()
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.enrollmentDate);
    }
}
