package com.cbat.exceptionhandler.util;

import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.config.CbatExceptionReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class ResponseUtil {
//    @Value("${cbat.exceptionhandler.code.success}")
    protected static String SUCCESS_CODE;
//    @Value("${cbat.exceptionhandler.code.fail}")
    protected static String FAILE_CODE;
    //    @Value("${cbat.exceptionhandler.code.systemError}")
    public static String SYSTEM_ERROR_CODE;
    //    @Value("${cbat.exceptionhandler.code.notexist}")
    public static String NOT_EXIST_CODE;
    /**
     * 请求成功
     * 状态码--200
     * @param data
     * @return
     */
    public static Response success(Object data){
        Response response = new Response();
        response.setData(data);
        response.setStatu(true);
        response.setCode(SUCCESS_CODE);
        return response;
    };


    /**
     * 请求成功
     * 状态码--200
     * @param data
     * @return
     */
    public static Response success(Object data,long count){
        Response response = new Response();
        response.setData(data);
        response.setStatu(true);
        response.setCode(SUCCESS_CODE);
        response.setCount(count);
        return response;
    };
    /**
     * 请求成功
     * 状态码--200
     * @return
     */
    public static Response success(){
        Response response = new Response();
        response.setStatu(true);
        response.setCode(SUCCESS_CODE);
        return response;
    };

    /**
     * 请求失败
     * @param data
     * @param errorCode 错误表中的错误码
     * @return
     */
    public static Response fail(Object data,String errorCode){
        Response response = new Response();
        response.setData(data);
        response.setStatu(false);
        response.setCode(FAILE_CODE);
        CbatExceptionReader.getErrorMsg(errorCode);
        return response;
    };

    /**
     * 请求失败
     * @param errorCode 错误表中的错误码
     * @return
     */
    public static Response fail(String errorCode){
        Response response = new Response();
        response.setStatu(false);
        response.setCode(FAILE_CODE);
        response.setMsg(CbatExceptionReader.getErrorMsg(errorCode));
        return response;
    };


}
