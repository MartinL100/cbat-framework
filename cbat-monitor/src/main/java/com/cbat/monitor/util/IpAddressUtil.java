package com.cbat.monitor.util;

import com.cbat.monitor.vo.AliyIpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

public class IpAddressUtil {
    @Autowired
    private   RestTemplate restTemplate;
    private static IpAddressUtil ipAddressUtil ;

    /**
     * 从request中获取ip地址
     * @param request
     * @return
     */
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

    /**
     * 将ip转化为实际地址
     * @param ip
     * @return
     */
    public static AliyIpVO ipToArea(String ip){
        AliyIpVO forObject = ipAddressUtil.restTemplate
                .getForObject("http://taobao.com/service/getIpInfo.php?ip={ip}", AliyIpVO.class,ip);
        return forObject;
    }


    @PostConstruct
    void init(){
        ipAddressUtil = this;
    }
}
