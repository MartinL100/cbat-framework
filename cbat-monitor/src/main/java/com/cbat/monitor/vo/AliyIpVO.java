package com.cbat.monitor.vo;

import java.io.Serializable;

public class AliyIpVO implements Serializable{
    private Integer code;
    private Address address;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
