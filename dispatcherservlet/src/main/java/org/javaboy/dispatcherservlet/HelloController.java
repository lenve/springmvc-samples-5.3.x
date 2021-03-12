package org.javaboy.dispatcherservlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/javaboy")
public class HelloController {

//    @GetMapping("/hello/**/hello")
    public String hello() {
        return "/hello/**/hello";
    }
    @GetMapping("/h?llo")
    public String hello2() {
        return "/h?llo";
    }
//    @GetMapping("/**/*.html")
    public String hello3() {
        return "/**/*.html";
    }
    @GetMapping("/hello/{p1}/{p2}")
    public String hello4(@PathVariable String p1, @PathVariable String p2) {
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        return "/hello/{p1}/{p2}";
    }
    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public void handle(@PathVariable String name, @PathVariable String version, @PathVariable String ext) {
        System.out.println("name = " + name);
        System.out.println("version = " + version);
        System.out.println("ext = " + ext);
    }

    @GetMapping("/javaboy/{*path}")
    public void hello6(@PathVariable String path) {
        System.out.println("path = " + path);
    }

    @GetMapping("/aaa")
    public String hello99() {
        return "aaa";
    }

}
