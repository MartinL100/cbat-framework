package com.cbat.exception.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {

    public static String getIpAddress(HttpServletRequest request){
        String Xip = request.getHeader("X-Real-IP");
        String Xfor = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(Xfor)&&!"unKnown".equalsIgnoreCase(Xfor)){
                int index = Xfor.indexOf(",");
                if (index!=-1){
                    return Xfor.substring(0,index);
                }else {
                    return Xfor;
                }
        }

        if(!StringUtils.isEmpty(Xip)&&!"unKnown".equalsIgnoreCase(Xip)){
            return Xip;
        }
        if (StringUtils.isEmpty(Xip)||"unKnown".equalsIgnoreCase(Xip)){
            Xip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(Xip)||"unKnown".equalsIgnoreCase(Xip)){
            Xip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(Xip)||"unKnown".equalsIgnoreCase(Xip)){
            Xip = request.getHeader("HTTP_Client_IP");
        }
        if (StringUtils.isEmpty(Xip)||"unKnown".equalsIgnoreCase(Xip)){
            Xip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(Xip)||"unKnown".equalsIgnoreCase(Xip)){
            Xip = request.getRemoteAddr();
        }

        return Xip;
    }
}
