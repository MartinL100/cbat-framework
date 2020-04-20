package com.cbat.exceptionhandler.controller;

import com.cbat.exceptionhandler.Bean.Response;
import com.cbat.exceptionhandler.util.CbatException;
import com.cbat.exceptionhandler.util.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public Response Test(int t){
        System.out.println("访问 test 成功");
        Response response = null;
        String s ="";
        if (1==t){
            response = ResponseUtil.success(null);
        }else if(2==t){
            throw new CbatException("E00000001");
        }else if(3==t){
            t=1/0;
        }

        return response;
    }
}
