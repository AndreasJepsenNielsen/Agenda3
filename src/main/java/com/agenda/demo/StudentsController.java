package com.agenda.demo;

import com.agenda.demo.Interfaces.IStudentRepository;
import com.agenda.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.Gregorian;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
public class StudentsController {



    @Autowired
    private IStudentRepository repository = new StudentRepository();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students",repository.get());
        return "index";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model)
    {
        model.addAttribute("student",repository.get(id));
        return "details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Student student) {
        System.out.println(student);
        repository.create(student);

        return "redirect:/";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("student",repository.get(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Student student){
       repository.delete(student);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {

        model.addAttribute("student", repository.get(id));

        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student) {
    repository.update(student);
    return "redirect:/";
    }




}
