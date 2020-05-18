package com.cbat.monitor.config;

import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.service.IVisitService;
import com.cbat.monitor.util.CbatMonitorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class CbatMonitorHandlerInterceptor implements HandlerInterceptor {
    public static final String VISIT_INFO ="VISIT_INFO";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
       if (handler instanceof HandlerMethod){
           CbatMonitorUtil.saveHandlerMethodMonitor(request);
       }else if (handler instanceof ResourceHttpRequestHandler){
           CbatMonitorUtil.saveViewMonitor(request);
       }

        return true;
    }
}
