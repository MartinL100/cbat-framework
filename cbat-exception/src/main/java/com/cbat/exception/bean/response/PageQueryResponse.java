package com.cbat.exception.bean.response;

import java.util.List;

public class PageQueryResponse<T> extends BaseResponse {
    private int count;
    private List<T>data;

    public PageQueryResponse( List<T> data,int count) {
        this.count = count;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
