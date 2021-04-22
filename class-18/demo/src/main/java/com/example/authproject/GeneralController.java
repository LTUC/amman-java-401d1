package com.example.authproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping
    public String getHomePage(){
        return "homepage.html";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
