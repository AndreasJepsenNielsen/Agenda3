package com.agenda.demo;

import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.util.calendar.Gregorian;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
public class StudentsController {

    static ArrayList<Student> students = new ArrayList<>();

    public static void fillStudents()
    {
        Student student = new Student(1,"Kasper","Lovin", new Date(),"2341");
        Student student1 = new Student(2,"Kasper","Lovin", new Date(),"2341");
        Student student2 = new Student(3,"Kasper","Lovin", new Date(),"2341");
        Student student3 = new Student(4,"Kasper","Lovin", new Date(),"2341");

        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("students",students);
        return "index";
    }
}
