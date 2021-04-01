package org.javaboy.defaultview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class HelloController2 {
    @GetMapping("/02")
    public void hello() {
        int i = 1 / 0;
    }
    @GetMapping("/03")
    public void hello2() {
        String a = null;
        a.substring(9);
    }
}
