package org.javaboy.param_resolver2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
public class MyHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler handler;

    public MyHandlerMethodReturnValueHandler(HandlerMethodReturnValueHandler handler) {
        this.handler = handler;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return handler.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "ok");
        map.put("data", returnValue);
        handler.handleReturnValue(map, returnType, mavContainer, webRequest);
    }
}
