package com.cbat.exception.util;

import com.cbat.exception.annotation.StatuCode;
import com.cbat.exception.bean.response.BaseResponse;
import com.cbat.exception.bean.response.PageQueryResponse;
import com.cbat.exception.bean.response.QueryResonse;

import java.util.List;

public class ResponseUtil {
    /**
     * 带数据返回成功
     * @param data
     */
    public static QueryResonse  success(Object data){
        QueryResonse resonse = new QueryResonse();
        resonse.setData(data);
        resonse.setCode(StatuCode.SUCCESS.getCode());
        resonse.setMsg(StatuCode.SUCCESS.getMsg());
        return resonse;
    }
    public static BaseResponse  success(){
        BaseResponse resonse = new BaseResponse();
        resonse.setCode(StatuCode.SUCCESS.getCode());
        resonse.setMsg(StatuCode.SUCCESS.getMsg());
        return resonse;
    }
   public static PageQueryResponse initPageResult(List data,int count){
       PageQueryResponse response = new PageQueryResponse(data,count);
       response.setCode(StatuCode.SUCCESS.getCode());
       response.setMsg(StatuCode.SUCCESS.getMsg());
        return response;
   }


   public static BaseResponse fail(){
       BaseResponse baseResponse = new BaseResponse();
       baseResponse.setMsg(StatuCode.FAILED.getMsg());
       baseResponse.setCode(StatuCode.FAILED.getCode());
       return baseResponse;
   }
}
