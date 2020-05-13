package com.cbat.exception.controller;


import com.cbat.exception.bean.response.BaseResponse;
import com.cbat.exception.util.IpAddressUtil;
import com.cbat.exception.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.LongAdder;

@RestController
public class CbatErrorController implements ErrorController{
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static volatile LongAdder count = new LongAdder();
    /**
     * 由于添加了统一异常处理，所以此处拦截的只有404异常
     * @param request
     * @return
     */

    @RequestMapping("/error")
    public BaseResponse error(HttpServletRequest request){
        count.add(1);
        String ip = IpAddressUtil.getIpAddress(request);
        //todo 记录非法访问项目的信息，防止恶意攻击
        logger.warn("访问了不存在的页面,次数："+count.longValue()+"ip:"+ip);
        return ResponseUtil.fail();
    }
    @Override
    public String getErrorPath() {
        return null;
    }



}
