package org.javaboy.defaultview;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/", ".jsp");
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        for (HandlerExceptionResolver resolver : resolvers) {
            if (resolver instanceof AbstractHandlerMethodExceptionResolver) {
                ((AbstractHandlerMethodExceptionResolver) resolver).setMappedHandlerClasses(HelloController.class);
            }
        }
    }
    @Bean
    SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.put("java.lang.ArithmeticException", "11");
        mappings.put("java.lang.NullPointerException", "22");
        resolver.setExceptionMappings(mappings);
        Properties statusCodes = new Properties();
        statusCodes.put("11", "500");
        statusCodes.put("22", "500");
        resolver.setStatusCodes(statusCodes);
        return resolver;
    }
}
