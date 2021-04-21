package com.crudapp.crudapp;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MajorRepository majorRepository;

    @GetMapping("/")
    @ResponseBody
    public String homePage(){
        return "home page";
    }

    @GetMapping("/students")
    public String getAllStudents(Model m){
        m.addAttribute("students",studentRepository.findAll());
        return "test";
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Integer id){
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity(student, HttpStatus.OK);
    }


    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(String firstName, String lastName, Integer majorId){
        Major major = majorRepository.findById(majorId).get();
        Student newStudent = new Student(firstName,lastName, major);
        studentRepository.save(newStudent);
        return new ResponseEntity(newStudent, HttpStatus.OK);
    }

}
