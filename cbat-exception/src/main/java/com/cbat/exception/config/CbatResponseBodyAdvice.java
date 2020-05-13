package com.cbat.exception.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.cbat.exception.annotation.ResponseUnify;
import com.cbat.exception.bean.response.BaseResponse;
import com.cbat.exception.util.ResponseUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;


@RestController
@ControllerAdvice
public class CbatResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    public static final String RESONSE_JSON_ANNO = "RESONSE_JSON_ANNO";
    /**
     * 此处判断是否需要对结果进行包装
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes atts = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = atts.getRequest();
        ResponseUnify responseUnify = (ResponseUnify) request.getAttribute(RESONSE_JSON_ANNO);
        return responseUnify==null ? false:true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
       if (null == body){
           return ResponseUtil.success();
       }

        if(body instanceof BaseResponse){
            return body;
        }
        if (body instanceof String){
           //返回结果为String时需要将数据转化为json，否则会抛异常
            return JSONUtil.parse(ResponseUtil.success(body)).toStringPretty();

        }
        return ResponseUtil.success(body);
    }
}
