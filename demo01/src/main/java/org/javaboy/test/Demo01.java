package org.javaboy.test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class Demo01 {
    public static void main(String[] args) {
        Method[] methods = Cat.class.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println(name+"("+ Arrays.toString(parameterTypes) +")");
        }
    }

}
