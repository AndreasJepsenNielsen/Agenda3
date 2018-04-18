package com.agenda.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class CoursesController {

    static ArrayList<Course> courses = new ArrayList<>();

    public static void fillCourses()
    {
        Course course = new Course(1,"Software Construction",new Date(),30);
        Course course1 = new Course(2,"IT And organisation", new Date(),10);
        Course course2 = new Course(3,"Software Design",new Date(),25);
        Course course3 = new Course(4,"TECH",new Date(),10);

        courses.add(course);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    @GetMapping("/Courses")
    public String index(Model model){
        model.addAttribute("courses",courses);
        return "course";
    }
}
