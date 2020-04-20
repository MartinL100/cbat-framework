package com.cbat.usermanager.config;

import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.service.IPermisService;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public abstract class ShiroFilterConfig {
    @Autowired
    IPermisService permisService;
    @Bean("shiroFilterMap")
    public Map getFilterMap(){
        Map shiroFilterMap = new HashMap();
//        shiroFilterMap.put("/test","authc");
        addFilterFomDataBase( shiroFilterMap);
        customInitFilter(shiroFilterMap);
        return shiroFilterMap;
    }

    /**
     * 从数据库 Permissiom表查询所有需要被拦截的url
     * 并放入到过滤器中
     * @param map
     */
    public void addFilterFomDataBase(Map map){
        List<PermissionBean> permissions = permisService.findAll();
        for (PermissionBean p:permissions) {
            map.put(p.getPermissionUrl(),"perms["+p.getPermissionUrl()+"]");
        }
    }

    /**
     * 自定义实现拦截器
     * 此步骤放在最尾，可手动清除前面的所有规则
     * @param shiroFilterMap shiro过滤器map
     */
    public abstract void customInitFilter(Map shiroFilterMap);

    /**
     * 自定义认证规则
     * 此步骤放在最尾，可手动清除前面的认证策略
     * @param simpleAuthorizationInfo 认证信息
     */
    public abstract void customRealm(SimpleAuthorizationInfo simpleAuthorizationInfo);
}
