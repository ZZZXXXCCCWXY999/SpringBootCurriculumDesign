package xyz.zxcwxy999.curriculumdesign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.zxcwxy999.curriculumdesign.dao.BookDao;
import xyz.zxcwxy999.curriculumdesign.domain.Book;

@SpringBootTest
class BookTest {

    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {
        Book[] book=bookDao.listAll();
        for (int i = 0; i < book.length; i++) {
            System.out.println(book[i]);
        }

    }

}
