package com.cbat.usermanager.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;
import java.util.Map;
@PropertySource("classpath:cbat-application.properties")
@Configuration
public class ShrioConfig {
    @Value("${cbat.usermanager.url.login}")
    private String loginUrl ;
    @Value("${cbat.usermanager.url.authorized}")
    private String authorizedUrl ;
    @Resource(name = "shiroFilterMap")
    private Map<String,String> shiroFilterMap;
    //过滤器
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        factoryBean.setFilterChainDefinitionMap(shiroFilterMap);
        factoryBean.setLoginUrl(loginUrl);
        factoryBean.setUnauthorizedUrl(authorizedUrl);
        return factoryBean;
    }

    //关联realm
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean("userRealm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }
}
