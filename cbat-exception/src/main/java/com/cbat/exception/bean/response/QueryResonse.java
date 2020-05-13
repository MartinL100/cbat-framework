package com.cbat.exception.bean.response;

import com.cbat.exception.bean.response.BaseResponse;

public class QueryResonse extends BaseResponse {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
