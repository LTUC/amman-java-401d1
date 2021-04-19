package com.crudapp.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MajorController {

    @Autowired
    MajorRepository majorRepository;

    @GetMapping("/majors")
    public String getAllStudents(Model m){
        m.addAttribute("majors",majorRepository.findAll());
        return "test";
    }

    @GetMapping("/majors/{id}")
    public ResponseEntity<Major> getStudentById(@PathVariable(value="id") Integer id){
        Major major = majorRepository.findById(id).get();
        return new ResponseEntity(major, HttpStatus.OK);
    }

    @PostMapping("/majors")
    public ResponseEntity<Major> addStudent(String majorCode, String majorName){
        Major newMajor = new Major(majorCode,majorName);
        majorRepository.save(newMajor);
        return new ResponseEntity(newMajor, HttpStatus.OK);
    }
}
