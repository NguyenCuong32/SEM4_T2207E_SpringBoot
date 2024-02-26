package com.fai.SecurityDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Index(){
        return "/index";
    }
    @GetMapping("/pricing")
    public String Pricing(){
        return "/pricing";
    }
}
