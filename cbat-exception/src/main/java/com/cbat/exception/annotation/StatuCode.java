package com.cbat.exception.annotation;

public enum  StatuCode {
    SUCCESS("1","访问成功")
    , FAILED("0","访问失败")

    ,USERNAME_NOT_EXEIT("40000001","用户名不存在")
    ,PWD_MISTAKE("40000002","密码错误")



    ,ILLEGAL_STATE("50000001","非空参数不能为空")
    ,SERVICE_ERROR("50000002","处理业务出错");
    private String code;
    private String msg;
















    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StatuCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
