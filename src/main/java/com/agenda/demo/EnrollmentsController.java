package com.agenda.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnrollmentsController {

    @RequestMapping("/Enrollments")
    public String getEnrollments(){
        return "Enrollments";
    }
}
