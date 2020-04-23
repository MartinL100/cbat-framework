package com.cbat.usermanager.controller;

import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.ResponseUtil;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping(value = "/login",name = "用戶登陆")
    public Response logIn(UserBean userBean){
        //MD5加密
        userBean.setPwd(MD5Util.MD5EncodeUtf8(userBean.getPwd()));
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUserName(),userBean.getPwd());
        try {
            subject.login(token);
            return ResponseUtil.success();
        } catch (UnknownAccountException e) {
            //用户名不存在
            return ResponseUtil.fail("E00000006");
        }catch (IncorrectCredentialsException e) {
            //密码错误
            return ResponseUtil.fail("E00000007");
        }

    }
    @RequestMapping(value = "/logout",name = "用戶登出")
    public Response logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseUtil.success();
    }
}
