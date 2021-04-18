package com.classdemo.classdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BooksController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello";
    }

    @GetMapping("/books")
    public String getBook(Model m){

        BookModel hp = new BookModel(1,"J.K. Rowlling", "Harry Potter and the prisonor of Azkaban");
        BookModel digitalFortress = new BookModel(2,"Dan Brown", "Digital Fortress");
        BookModel crimeAndPunishment = new BookModel(3,"Distoivski", "Crime and Punishment");

        List<BookModel> books = new ArrayList<>();
        books.add(hp);
        books.add(digitalFortress);
        books.add(crimeAndPunishment);

        m.addAttribute("books",books);
        return "books.html";
    }

}
