package org.javaboy.springmvc02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Controller
public class MyController {
    @RequestMapping({"/hello","/hello2"})
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "javaboy");
        return mv;
    }

    @GetMapping("/hello2")
    public void hello2(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
//        req.getRequestDispatcher("/01.jsp").forward(req, resp);
//        resp.sendRedirect("/01.jsp");
//        resp.setStatus(302);
//        resp.addHeader("Location", "/01.jsp");
        resp.getWriter().write("hello javaboy");
    }

    @GetMapping(value = "/hello3",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String hello3(Model model) {
//        return "forward:/01.jsp";
//        return "redirect:/01.jsp";
        model.addAttribute("name", "江南一点雨");
        return "hello 江南一点雨";
    }
}
