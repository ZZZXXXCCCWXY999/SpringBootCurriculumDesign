package xyz.zxcwxy999.curriculumdesign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.zxcwxy999.curriculumdesign.dao.BookDao;
import xyz.zxcwxy999.curriculumdesign.domain.Book;
import xyz.zxcwxy999.curriculumdesign.service.BookService;

@SpringBootTest
class BookTest {

    @Autowired
    BookDao bookDao;
    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        Book[] book=bookDao.listAll();
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i]);
        }

    }

    @Test
    void add(){
        Book book=new Book();
        book.setName("《巨星是怎样炼成的》");
        book.setAuthor("王啸岳");
        book.setPublishing("巨星出版社");
        book.setPrice(10.5);
        System.out.println(bookService.createBook(book));
    }
    @Test
    void edit(){
        Book book=new Book();
        book.setId(3);
        book.setName("《巨星是怎样炼成的》");
        book.setAuthor("王啸岳");
        book.setPublishing("巨星出版社");
        book.setPrice(10.5);
        System.out.println(bookService.updateBook(book));
    }
    @Test
    void delete(){
        int i=1;
        System.out.println(bookService.deleteBook(i));
    }


}
