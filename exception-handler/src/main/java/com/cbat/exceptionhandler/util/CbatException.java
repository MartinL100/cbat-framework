package com.cbat.exceptionhandler.util;

import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.config.CbatExceptionReader;

public class CbatException extends RuntimeException {
    private Response response ;
    public CbatException(String code){
        super(CbatExceptionReader.getErrorMsg(code));
        response = new Response();
        this.response.setCode(code);
        this.response.setMsg(CbatExceptionReader.getErrorMsg(code));

    }
    public Response getResponse() {
        return response;
    }


}
