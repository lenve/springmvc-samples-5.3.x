package org.javaboy.fileupload.controller;

import org.javaboy.fileupload.model.Student;
import org.javaboy.fileupload.validation.ValidationGroup1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 springmvc spring
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Controller
public class StudentController {
    @PostMapping("/student")
//    @ResponseBody
    public String addStudent(@Validated(ValidationGroup1.class) @ModelAttribute("s") Student student, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println("allError.getDefaultMessage() = " + allError.getDefaultMessage());
            }
            return "addstudent";
        }
        return "hello";
    }

    @PostMapping("/addstudent2")
    public String addStudent2(String name, String email, Integer age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("age", age);
        return "addstudent";
    }

    @ModelAttribute("info")
    public Map<String,Object> info() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "javaboy");
        map.put("site", "http://www.javaboy.org");
        return map;
    }

    @GetMapping("/add")
    public String addStudent3() {
        return "addstudent";
    }
}
