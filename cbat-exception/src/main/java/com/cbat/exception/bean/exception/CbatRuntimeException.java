package com.cbat.exception.bean.exception;

import com.cbat.exception.annotation.StatuCode;
import com.cbat.exception.bean.response.BaseResponse;

public class CbatRuntimeException extends RuntimeException {
    private BaseResponse response;
    public CbatRuntimeException(String  code,String message) {
        super(message);
        this.response = new BaseResponse();
        this.response.setCode(code);
        this.response.setMsg(message);
    }

    public CbatRuntimeException(StatuCode statuCode) {
        super(statuCode.getMsg());
        this.response = new BaseResponse();
        this.response.setCode(statuCode.getCode());
        this.response.setMsg(statuCode.getMsg());
    }

    public BaseResponse getResponse() {
        return response;
    }
}
