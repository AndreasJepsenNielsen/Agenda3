package com.agenda.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class CoursesController {

    static ArrayList<Course> courses = new ArrayList<>();

    public static void fillCourses()
    {
        Course course = new Course(0,"Software Construction",new Date(),30);
        Course course1 = new Course(1,"IT And organisation", new Date(),10);
        Course course2 = new Course(2,"Software Design",new Date(),25);
        Course course3 = new Course(3,"TECH",new Date(),10);

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

    @GetMapping("/createC")
    public String create(Model model) {
        model.addAttribute("Course", new Course());
        return "createC";
    }

    @PostMapping("/createC")
    public String create(@ModelAttribute Course course) {

        int index = (courses.size());

        course.setId(index);
        courses.add(course);

        return "redirect:/Courses";
    }

    @GetMapping("/detailsC")
    public String details(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("Course",courses.get(id));
        return "detailsC";
    }


    @GetMapping("/deleteC")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("Course",courses.get(id));
        return "deleteC";
    }

    @PostMapping("/deleteC")
    public String delete(@ModelAttribute Course course){
        courses.remove(course.getId());
        return "redirect:/Courses";
    }

    @GetMapping("/updateC")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("Course", courses.get(id));

        return "updateC";
    }

    @PostMapping("/updateC")
    public String update(@ModelAttribute Course course) {
        courses.set(course.getId(),course);
        return "redirect:/Courses";
    }



}
