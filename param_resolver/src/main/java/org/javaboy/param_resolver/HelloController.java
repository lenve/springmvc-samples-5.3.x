package org.javaboy.param_resolver;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@CurrentUserName String name) {
        return "hello "+name;
    }
    @GetMapping("/hello2")
    public String hello2(Principal principal) {
        return "hello " + principal.getName();
    }

    @PostMapping("/hello3")
    public void upload(@RequestParam MultiValueMap map) {

    }
}