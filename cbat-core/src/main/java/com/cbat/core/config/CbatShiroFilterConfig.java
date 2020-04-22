package com.cbat.core.config;

import com.cbat.usermanager.config.ShiroFilterConfig;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class CbatShiroFilterConfig extends ShiroFilterConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void customInitFilter(Map shiroFilterMap) {

        shiroFilterMap.put("/login","anon");
        shiroFilterMap.put("/*","authc");





    }

    @Override
    public void customRealm(SimpleAuthorizationInfo simpleAuthorizationInfo) {
        logger.info("进入自定义认证器");

    }


}
