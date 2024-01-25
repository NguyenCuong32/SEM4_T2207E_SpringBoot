package com.fai.universitymvccrud.Universitymvc.controller;

import com.fai.universitymvccrud.Universitymvc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String Index(Model model){
        return  "index";
    }
}
