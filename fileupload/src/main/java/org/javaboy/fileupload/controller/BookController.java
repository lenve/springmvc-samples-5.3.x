package org.javaboy.fileupload.controller;

import org.javaboy.fileupload.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 springmvc
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@RestController
public class BookController {
    @GetMapping("/book/{id}")
//    @ResponseBody
    public Book getBookById(@PathVariable Integer id) {
        Book book = new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPublishDate(new Date());
        return book;
    }

    @GetMapping("/books")
//    @ResponseBody
    public List<Book> getAllBoos() {
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setAuthor("罗贯中");
        b1.setName("三国演义");
        b1.setId(1);
        b1.setPublishDate(new Date());
        books.add(b1);
        Book b2 = new Book();
        b2.setId(2);
        b2.setName("红楼梦");
        b2.setAuthor("曹雪芹");
        b2.setPublishDate(new Date());
        books.add(b2);
        return books;
    }

    @PostMapping("/book")
//    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        System.out.println("book = " + book);
        return book;
    }
}
