package xyz.zxcwxy999.curriculumdesign.service;

import xyz.zxcwxy999.curriculumdesign.domain.Book;

public interface BookService {
    /**
     * 添加图书
     * @param book
     * @return
     */
    public boolean createBook(Book book);

    /**
     * 删除图书
     * @param id
     * @return
     */
    public boolean deleteBook(int id);

    /**
     * 修改图书
     * @param book
     * @return
     */
    public boolean updateBook(Book book);

    /**
     * 获取全部图书
     * @return
     */
    public Book[] listBook();


}
