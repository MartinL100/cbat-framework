package com.cbat.exception.bean.exception;

import com.cbat.exception.bean.response.BaseResponse;

public class CbatIllegalStateException extends RuntimeException {
    private BaseResponse response;
    public CbatIllegalStateException() {
        super();
    }


    public CbatIllegalStateException(String code, String message) {
        super(message);
        this.response = new BaseResponse();
        this.response.setCode(code);
        this.response.setMsg(message);
    }

    public BaseResponse getResponse() {
        return response;
    }
}
