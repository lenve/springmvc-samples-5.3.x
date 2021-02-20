package org.javaboy.springmvc02.controller;

import org.javaboy.springmvc02.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 springmvc
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Controller
@RequestMapping("/book")
public class BookController {
    //   /book/getbook
    @RequestMapping("/getbook")
    public ModelAndView getBook() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "BookController");
        return mv;
    }

    @GetMapping("/book")
    public String book() {
        return "addbook";
    }

    @PostMapping(value = "/addbook",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addBook(@RequestParam("bookname") String name, String author, @RequestParam(defaultValue = "99") Double price) {
        System.out.println("name = " + name);
        return name + ">>>" + author + ">>>" + price;
    }

    @PostMapping(value = "/addbook2",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addBook2(Book book) {
        return book.toString();
    }
}
