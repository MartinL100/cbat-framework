package com.cbat.usermanager.config;


import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm 实现认证
 */

public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermisService permisService;
    @Autowired
    private ShiroFilterConfig shiroFilterConfig;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("开始执行用户授权");
        Subject subject = SecurityUtils.getSubject();
        /**利用session减少数据库穿透次数*/
        Object authorizationInfo = subject.getSession().getAttribute("simpleAuthorizationInfo");
        if (null!=authorizationInfo){
            return (AuthorizationInfo) authorizationInfo;
        }
        logger.info("开始执行用户授权数据库查询");
        UserBean userBean = (UserBean) subject.getPrincipal();
        List<RoleBean> roleBeans = roleService.findByUserId(userBean.getUserId());
        List<PermissionBean>permissionBeans= new ArrayList<PermissionBean>();
        for (RoleBean r:roleBeans) {
            List<PermissionBean> permises = permisService.getPermises(r.getRoleId());
            if(null!=permises&&0!=permises.size()){
                permissionBeans.addAll(permises) ;
            }

        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(null!=roleBeans){
            for (RoleBean r:roleBeans) {
                info.addRole(r.getRoleName());
            }
        }
        /**添加认证Permiss*/
        if(null!=permissionBeans){
            for (PermissionBean p: permissionBeans) {
                info.addStringPermission(p.getPermissionUrl());
            }
        }
        /**执行自定义逻辑*/
        shiroFilterConfig.customRealm(info);

        subject.getSession().setAttribute("simpleAuthorizationInfo",info);
        return info;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("开始执行认证操作");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserBean user = userService.findByUserName(token.getUsername());
        if(null == user){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }

}
