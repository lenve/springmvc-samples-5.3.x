package org.javaboy.springmvc02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/user")
public class UserController {
    //http://localhost:8080/user/getuser
//    @RequestMapping(value = "/getuser",method = {RequestMethod.GET,RequestMethod.POST})
    @GetMapping("/getuser")//@RequestMapping(value = "/getuser",method = {RequestMethod.GET})
    public ModelAndView getUser() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "UserController");
        return mv;
    }

    @RequestMapping("/getuser2")
    @ResponseBody
    public void getUser2() {
        System.out.println("getUser2");
    }

}
