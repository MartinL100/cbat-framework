package com.cbat.exceptionhandler.config;

import com.cbat.exceptionhandler.Bean.Response;
import com.cbat.exceptionhandler.util.CbatException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class CbatExceptionHandler {

    @ExceptionHandler(CbatException.class)
    public Response CbatExceptionHandler(HttpServletRequest request,CbatException e){
        Response response = e.getResponse();
        response.setStatu(false);
        return response;
    }


    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(HttpServletRequest request,Exception e){
        Response response = new Response();
        response.setMsg(CbatExceptionReader.SYSTEM_ERROR);
        response.setCode("500");
        response.setStatu(false);
        return response;
    }
}
