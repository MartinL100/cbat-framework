package com.cbat.usermanager.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CbatErrorController  implements ErrorController{
    @RequestMapping("/error")
    public String error(HttpServletRequest request,Exception e){
        return e.getMessage();

    }
    @Override
    public String getErrorPath() {
        return null;
    }
}
