package org.javaboy.param_resolver2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

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
public class HelloController {
    @PostMapping("/hello")
    public void hello(@RequestParam MultiValueMap<String, Part> map) throws IOException {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Part part = map.get(key).get(0);
            part.write("/Users/sang/workspace/springmvc/springmvc-samples-5.3.x/param_resolver2/"+part.getSubmittedFileName());
            System.out.println(key + ">>>" + part.getSubmittedFileName()+""+part.getSize());
        }
    }

    @GetMapping("/hello2")
    public void hello2(@RequestParam(value = "${aa.bb}") String name) {
        System.out.println("name = " + name);
    }

    @GetMapping("/hello/{id}")
    public void hello3(@PathVariable Long id) {
        System.out.println("id = " + id);
    }

    @PostMapping("/hello4")
    public void hello4(MultipartFile file) {
        System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
    }

    @GetMapping("/hello5")
    public String hello5(Map<String,String> model) {
//        model.addAttribute("hello", "hello javaboy");
        model.put("hello", "hello javaboy");
        return "05";
    }
}
