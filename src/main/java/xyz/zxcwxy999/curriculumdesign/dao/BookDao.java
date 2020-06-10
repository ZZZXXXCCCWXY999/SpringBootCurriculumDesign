package xyz.zxcwxy999.curriculumdesign.dao;

import org.apache.ibatis.annotations.*;
import xyz.zxcwxy999.curriculumdesign.domain.Book;

@Mapper
public interface BookDao {

    /**
     * 添加图书
     * @return
     */
    @Insert("insert into book (name,author,publishing,price) values (#{book.name},#{book.author},#{book.publishing},#{book.price})")
    public int addBook(@Param("book")Book book);

    /**
     * 删除图书
     * @return
     */
    @Delete("delete from book where id=#{id}")
    public int deleteBookById(@Param("id")int id);

    /**
     * 修改图书
     * @return
     */
    @Update("update book set name=#{book.name},author=#{book.author},publishing=#{book.publishing},price=#{book.price} where id=#{book.id}")
    public int editBook(@Param("book")Book book);

    /**
     * 获取所有图书
     * @return
     */
    @Select("select * from book")
    public Book[] listAll();


}
