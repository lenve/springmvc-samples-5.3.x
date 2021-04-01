package org.javaboy.modelfactory;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
@SessionAttributes("name")
public class HelloController {
    @GetMapping("/01")
    public String hello(Map<String,Object> map) {
        map.put("name", "javaboy");
//        model.addAttribute("name", "javaboy");
        return "forward:/index";
    }

    @GetMapping("/04")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    private void hello4(@SessionAttribute("name") String name) {
        System.out.println("name = " + name);
    }

    @GetMapping("/05")
    @ResponseBody
    public void hello5(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
    }

    @GetMapping("/03")
    @ResponseBody
    public void hello3(Model model) {
        Object name = model.getAttribute("name");
        System.out.println("name = " + name);
    }

    @GetMapping("/02")
    public String hello2(Model model) {
        model.addAttribute("name", "javaboy");
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Map<String,Object> map) {
        System.out.println("map.get(\"name\") = " + map.get("name"));
        return "01";
    }

    @ModelAttribute
    public USer uSer() {
        USer uSer = new USer("www.javaboy.org");
        return uSer;
    }
    @ModelAttribute
    public List<String> names() {
        return Collections.singletonList("666");
    }

    @GetMapping("/06")
    public void hello6() {
        System.out.println("hello");
    }
}
