package xyz.zxcwxy999.curriculumdesign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.zxcwxy999.curriculumdesign.domain.Book;
import xyz.zxcwxy999.curriculumdesign.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public String book(){
        Book[] books=bookService.listBook()    ;
        return null;
    }
    @PostMapping("/add")
    public String add(){
        return null;
    }
    @PostMapping("/edit")
    public String edit(){
        return null;
    }
    @DeleteMapping("/delete")
    public String delete(){
        return null;
    }
}
