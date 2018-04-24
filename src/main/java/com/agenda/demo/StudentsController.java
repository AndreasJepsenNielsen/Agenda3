package com.agenda.demo;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        Student student = new Student(0,"Lukas","Nielsen", new Date(),"20-10-98");
        Student student1 = new Student(1,"Andreas","Nielsen", new Date(),"12-11-95");
        Student student2 = new Student(2,"Matias","Gramkow", new Date(),"23-12-94");
        Student student3 = new Student(3,"Kasper","Lovin", new Date(),"13-11-88");

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

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) {
        int index = (students.size() + 1);
        student.setStudentId(index);
        students.add(student);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("student",students.get(id));
        return "details";
    }
}
