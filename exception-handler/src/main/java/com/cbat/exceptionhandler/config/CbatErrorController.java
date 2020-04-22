package com.cbat.exceptionhandler.config;


import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.ResponseUtil;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class CbatErrorController  implements ErrorController{
    /**
     * 由于添加了统一异常处理，所以此处拦截的只有404异常
     * @param request
     * @return
     */
    @RequestMapping("/error")
    public Response error(HttpServletRequest request){
        Response response = new Response();
        response.setCode(ResponseUtil.NOT_EXIST_CODE);
        response.setStatu(false);
        response.setMsg(CbatExceptionReader.getErrorMsg(ResponseUtil.NOT_EXIST_CODE));
        return response;
    }
    @Override
    public String getErrorPath() {
        return null;
    }



}
