package com.classdemo.classdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeneralController {

    @GetMapping("/helloworld")
    @ResponseBody
    public String showHelloWorld(){
        return "Test Hello World";
    }

    @GetMapping("/testtemplating")
    public String testParams(Model m, @RequestParam String id){
        m.addAttribute("name", "Esraa");
        m.addAttribute("age", "18");
        m.addAttribute("id",id);
        return "template.html";
    }

    @GetMapping("/testtemplating/{id}")
    public String showTemplate(Model m, @PathVariable("id") int id){
        m.addAttribute("name", "Esraa");
        m.addAttribute("age", "18");
        m.addAttribute("id",id);
        return "template.html";
    }

    // books
    // getAllBooks
    // getBook -> provide id
}
