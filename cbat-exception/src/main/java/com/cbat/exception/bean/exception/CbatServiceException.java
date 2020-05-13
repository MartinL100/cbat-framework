package com.cbat.exception.bean.exception;

import com.cbat.exception.bean.response.BaseResponse;

public class CbatServiceException extends RuntimeException{
    private BaseResponse response;
    public CbatServiceException() {
        super();
    }


    public CbatServiceException(String code, String message) {
        super(message);
        this.response = new BaseResponse();
        this.response.setCode(code);
        this.response.setMsg(message);
    }

    public BaseResponse getResponse() {
        return response;
    }
}
