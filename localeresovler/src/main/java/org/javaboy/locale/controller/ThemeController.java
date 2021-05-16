package org.javaboy.locale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ThemeResolver;

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
public class ThemeController {

    //将theme注入容器中
    @Autowired
    private ThemeResolver themeResolver;

    /**
     * 返回一个页面
     * */
    @GetMapping(path = "/index")
    public  String getPage(){
        return "index";
    }

    /**
     *请求方式：GET
     * 参数：theme
     * 请求url:/th/对应主题的文件
     */
//    @RequestMapping(path = "/01/{theme}",method = RequestMethod.GET)
//    public String theme1(@PathVariable("theme") String themeStr, HttpServletRequest request, HttpServletResponse response){
//        themeResolver.setThemeName(request,response, themeStr);
//        return "redirect:/01";
//    }

}