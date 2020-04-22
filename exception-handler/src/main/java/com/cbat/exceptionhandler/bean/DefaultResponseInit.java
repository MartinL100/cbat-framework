package com.cbat.exceptionhandler.bean;

import com.cbat.exceptionhandler.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:cbat-application.properties")
@Configuration
@Component
public class DefaultResponseInit extends ResponseUtil{


    @Value("${cbat.exceptionhandler.code.success}")
    public  void setSuccessCode(String successCode) {
        SUCCESS_CODE = successCode;
    }
    @Value("${cbat.exceptionhandler.code.fail}")
    public  void setFaileCode(String faileCode) {
        FAILE_CODE = faileCode;
    }
    @Value("${cbat.exceptionhandler.code.systemError}")
    public  void setSystemErrorCode(String systemErrorCode) {
        SYSTEM_ERROR_CODE = systemErrorCode;
    }
    @Value("${cbat.exceptionhandler.code.notExist}")
    public  void setNotExistCode(String notExistCode) {
        NOT_EXIST_CODE = notExistCode;
    }
}
