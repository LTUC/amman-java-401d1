package com.crudapp.crudapp;

import javax.persistence.*;
import java.util.List;

@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    // Select * from student where major_id = id
    @OneToMany(mappedBy = "major", cascade = CascadeType.ALL)
    private List<Student> students;

    public Major(){

    }

    public Major(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
