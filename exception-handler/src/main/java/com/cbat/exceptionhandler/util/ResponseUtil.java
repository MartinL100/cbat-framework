package com.cbat.exceptionhandler.util;

import com.cbat.exceptionhandler.Bean.Response;
import com.cbat.exceptionhandler.config.CbatExceptionReader;

public class ResponseUtil {

    public static Response success(Object data){
        Response response = new Response();
        response.setData(data);
        response.setStatu(true);
        response.setCode("200");
        response.setMsg(CbatExceptionReader.SUCCESS);
        return response;
    };
}
