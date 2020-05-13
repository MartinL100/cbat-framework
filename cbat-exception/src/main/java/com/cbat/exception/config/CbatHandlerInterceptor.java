package com.cbat.exception.config;

import com.cbat.exception.annotation.ResponseUnify;
import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.service.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Configuration
public class CbatHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    IVisitService visitService;
    public static final String VISIT_INFO ="VISIT_INFO";
    /**
     * 前置处理器判断handlerMethod是否被自定义注解标记
     * 从而判断返回结果是否需要包装
     * @see com.cbat.exception.config.CbatResponseBodyAdvice#supports(MethodParameter, Class)
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod){
            VisitBean visitInfo = visitService.save(request);
            request.setAttribute(CbatHandlerInterceptor.VISIT_INFO,visitInfo);
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class c = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (c.isAnnotationPresent(ResponseUnify.class)){
                request.setAttribute(CbatResponseBodyAdvice.RESONSE_JSON_ANNO,c.getAnnotation(ResponseUnify.class));
            }
            if (method.isAnnotationPresent(ResponseUnify.class)){
                request.setAttribute(CbatResponseBodyAdvice.RESONSE_JSON_ANNO,method.getAnnotation(ResponseUnify.class));

            }
        }
        return true;
    }
}
