package com.cbat.usermanager.test;

import com.cbat.usermanager.config.ShiroFilterConfig;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CustmFilter extends ShiroFilterConfig {

    @Override
    public void customInitFilter(Map shiroFilterMap) {
//        shiroFilterMap.put("/**","authc");
//        shiroFilterMap.put("/login","anon");
        shiroFilterMap = null;
    }

    @Override
    public void customRealm(SimpleAuthorizationInfo simpleAuthorizationInfo) {

    }
}
