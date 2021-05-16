package org.javaboy.locale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

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
public class LoginController {
    @Autowired
    MessageSource messageSource;
    @GetMapping("/login")
    public String login(String locale,HttpSession session) {
        if ("zh-CN".equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        } else if ("en-US".equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        }
        String username = messageSource.getMessage("login.username", null, LocaleContextHolder.getLocale());
        String password = messageSource.getMessage("login.password", null, LocaleContextHolder.getLocale());
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "login";
    }
    @GetMapping("/login2")
    public String login2(String locale, HttpSession session) {
/*        if ("zh-CN".equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        } else if ("en-US".equals(locale)) {
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        }*/
        String username = messageSource.getMessage("login.username", null, LocaleContextHolder.getLocale());
        String password = messageSource.getMessage("login.password", null, LocaleContextHolder.getLocale());
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "login";
    }
    @GetMapping("/login3")
    public String login3(String locale, HttpServletRequest req, HttpServletResponse resp) {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        if ("zh-CN".equals(locale)) {
            resolver.setLocale(req, resp, new Locale("zh", "CN"));
        } else if ("en-US".equals(locale)) {
            resolver.setLocale(req, resp, new Locale("en", "US"));
        }
        String username = messageSource.getMessage("login.username", null, LocaleContextHolder.getLocale());
        String password = messageSource.getMessage("login.password", null, LocaleContextHolder.getLocale());
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "login";
    }
}
