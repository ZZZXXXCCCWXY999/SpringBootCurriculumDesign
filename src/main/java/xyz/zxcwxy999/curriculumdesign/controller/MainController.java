package xyz.zxcwxy999.curriculumdesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.zxcwxy999.curriculumdesign.domain.Book;
import xyz.zxcwxy999.curriculumdesign.service.BookService;

/**
 * 主页控制器
 */
@Controller
public class MainController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        Book[] books = bookService.listBook();
        if (books == null) {
            model.addAttribute("nobook", "没有图书！！！");
        } else {
            model.addAttribute("book", books);
        }
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errMsg", "登录失败，用户名或密码错误！！！");
        return "loginerr";
    }

    @GetMapping("/book/add")
    public String add() {
        return "add";
    }

    @GetMapping("/book/edit")
    public String adderr() {
        return "edit";
    }

    @GetMapping("/book/addnew")
    public String addbook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("publishing") String publishing,
                          @RequestParam("price") String price) {
        double pprice = Double.parseDouble(price);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPublishing(publishing);
        book.setPrice(pprice);
        return bookService.createBook(book) ? "redirect:/index" : "redirect:/book/adderr";
    }
    @GetMapping("/book/delete/{id}")
    public String deletebook(@PathVariable("id") int id){
        return bookService.deleteBook(id)? "redirect:/index" : "redirect:/book/adderr";
    }
    @GetMapping("/book/editbook")
    public String editbook( @RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("publishing") String publishing,
                          @RequestParam("price") String price) {
        double pprice = Double.parseDouble(price);
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setPublishing(publishing);
        book.setPrice(pprice);
        return bookService.updateBook(book) ? "redirect:/index" : "redirect:/book/adderr";
    }

}
