package com.cbat.exception.controller;

import com.cbat.exception.annotation.ResponseUnify;
import com.cbat.exception.annotation.StatuCode;
import com.cbat.exception.bean.exception.CbatServiceException;
import com.cbat.exception.bean.response.BaseResponse;
import com.cbat.exception.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @ResponseUnify
    @RequestMapping("/test")
    public Object test(String is) throws Exception {
        Assert.notEmpty(is,"is不能为空");
        int i = Integer.parseInt(is);
        if (i==0){
            i=1/0;
        }if (i==1){
            BaseResponse response = new BaseResponse();
            response.setCode("1");
            response.setMsg("chenggong");
            return response;
        }if (i==2){
            throw new CbatServiceException(StatuCode.SERVICE_ERROR.getCode(),StatuCode.SERVICE_ERROR.getMsg());
        }
        if (i==3){
            return 1;
        }
        return "hello";
    }
}
