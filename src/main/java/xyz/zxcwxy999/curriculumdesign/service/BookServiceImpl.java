package xyz.zxcwxy999.curriculumdesign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zxcwxy999.curriculumdesign.dao.BookDao;
import xyz.zxcwxy999.curriculumdesign.domain.Book;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao bookDao;

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    @Override
    public boolean createBook(Book book) {
        return bookDao.addBook(book)>0?true:false;
    }

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBookById(id)>0?true:false;
    }

    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    @Override
    public boolean updateBook(Book book) {
        return bookDao.editBook(book)>0?true:false;
    }

    /**
     * 获取全部图书
     *
     * @return
     */
    @Override
    public Book[] listBook() {
        return bookDao.listAll();
    }
}
