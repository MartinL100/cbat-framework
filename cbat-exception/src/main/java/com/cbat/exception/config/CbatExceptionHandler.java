package com.cbat.exception.config;

import com.cbat.exception.bean.exception.CbatIllegalStateException;
import com.cbat.exception.bean.exception.CbatRuntimeException;
import com.cbat.exception.bean.exception.CbatServiceException;
import com.cbat.exception.bean.response.BaseResponse;
import com.cbat.exception.util.ResponseUtil;
import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.constans.VisitStatu;
import com.cbat.monitor.service.IVisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@RestController
@ControllerAdvice
public class CbatExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IVisitService visitService;
    @ExceptionHandler(CbatIllegalStateException.class)
    public BaseResponse exceptionHandler(HttpServletRequest request , CbatIllegalStateException e){
        updateRecord(request,e.getResponse().getMsg());
        BaseResponse response = e.getResponse();
        logger.warn(e.getMessage(),e);
        return response;
    }
    @ExceptionHandler(CbatServiceException.class)
    public BaseResponse exceptionHandler(HttpServletRequest request , CbatServiceException e){
        updateRecord(request,e.getResponse().getMsg());
        BaseResponse response = e.getResponse();
        logger.error(e.getMessage(),e);
        return response;
    }
    @ExceptionHandler(CbatRuntimeException.class)
    public BaseResponse exceptionHandler(HttpServletRequest request , CbatRuntimeException e){
        updateRecord(request,e.getResponse().getMsg());
        BaseResponse response = e.getResponse();
        logger.error(e.getMessage(),e);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(HttpServletRequest request , Exception e){
        updateRecord(request,"系统发生异常");
        logger.error("系统发生异常:",e);
        return ResponseUtil.fail();
    }

    private void updateRecord(HttpServletRequest request,String msg){
       VisitBean visitBean= (VisitBean) request.getAttribute(CbatHandlerInterceptor.VISIT_INFO);
       if (null!=visitBean){
           visitBean.setStatu(VisitStatu.FAILE);
           visitBean.setExpInfo(msg);
           visitBean.setLstModTime(new Timestamp(System.currentTimeMillis()));
           visitService.update(visitBean);
       }
    }
}
