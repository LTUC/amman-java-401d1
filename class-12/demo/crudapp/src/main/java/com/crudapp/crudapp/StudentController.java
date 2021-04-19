package com.crudapp.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public String getAllStudents(Model m){
        m.addAttribute("students" ,studentRepository.findAll());
        return "students.html";
    }

    @GetMapping("/addStudent")
    public String getAddStudentView(){
        return "addStudent.html";
    }

    @PostMapping("/students")
    public RedirectView addStudent(@RequestParam(value = "firstName") String firstName ,
                                   @RequestParam(value= "lastName") String secondName,
                                   @RequestParam(value="age") int age){
        Student student = new Student(firstName,secondName,age);
        studentRepository.save(student);
        return  new RedirectView("/students");
    }

}
