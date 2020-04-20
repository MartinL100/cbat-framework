package com.cbat.exceptionhandler.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
@Component
@PropertySource(value = "classpath:errorCode.properties",encoding = "utf-8")
@ConfigurationProperties(prefix = "cbat.error")
public class CbatExceptionReader {
    private static final String DEFAULT_ERROR_KSG = "没有该错误码，请将该错误码添加到库后再试";
    public static final String SYSTEM_ERROR = "系统发生异常，请联系工作人员或者稍后再试";
    public static final String SUCCESS = "访问成功";
    private static Map<String,String> codes = new HashMap<String, String>();
    public void setCodes(Map<String, String> codes) {
        this.codes = codes;
    }
    public static String getErrorMsg(@NotNull String code){
        if (codes.containsKey(code)){
            return codes.get(code);
        }
        return DEFAULT_ERROR_KSG;
    }
}