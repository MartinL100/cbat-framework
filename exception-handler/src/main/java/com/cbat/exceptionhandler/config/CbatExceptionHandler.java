package com.cbat.exceptionhandler.config;

import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.CbatException;
import com.cbat.exceptionhandler.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class CbatExceptionHandler {
Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(CbatException.class)
    public Response CbatExceptionHandler(HttpServletRequest request,CbatException e){
        logger.error(e.getResponse().getMsg(),e);
        Response response = e.getResponse();
        response.setStatu(false);
        return response;
    }


    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(HttpServletRequest request,Exception e){
        logger.error("系统发生错误",e);
        Response response = new Response();
        response.setMsg(CbatExceptionReader.getErrorMsg(ResponseUtil.SYSTEM_ERROR_CODE));
        response.setCode(ResponseUtil.SYSTEM_ERROR_CODE);
        response.setStatu(false);
        return response;
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public Response emptyResultDataAccessExceptionHandler(HttpServletRequest request,Exception e){
        logger.warn("该数据不存在",e);
        Response response = new Response();
        response.setMsg(CbatExceptionReader.getErrorMsg("B00000001"));
        response.setCode("B00000001");
        response.setStatu(false);
        return response;
    }


}
