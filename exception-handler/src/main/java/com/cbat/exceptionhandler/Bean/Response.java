package com.cbat.exceptionhandler.Bean;

public class Response {
    private String msg;
    private String code;
    private Object data;
    private Boolean statu;

    public Boolean getStatu() {
        return statu;
    }

    public void setStatu(Boolean statu) {
        this.statu = statu;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
