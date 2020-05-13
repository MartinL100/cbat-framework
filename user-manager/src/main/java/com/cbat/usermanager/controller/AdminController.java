package com.cbat.usermanager.controller;


import com.cbat.exception.annotation.ResponseUnify;
import com.cbat.exception.annotation.StatuCode;
import com.cbat.exception.bean.exception.CbatRuntimeException;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "用户认证")
@RestController
@ResponseUnify
public class AdminController {
    @ApiOperation("用戶登陆")
    @GetMapping(value = "/login", name = "用戶登陆")
    @PostMapping (value = "/login", name = "用戶登陆")
    public void logIn(UserBean userBean){
        //MD5加密
        userBean.setPwd(MD5Util.MD5EncodeUtf8(userBean.getPwd()));
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUserName(),userBean.getPwd());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //用户名不存在
            throw new CbatRuntimeException(StatuCode.USERNAME_NOT_EXEIT);
        }catch (IncorrectCredentialsException e) {
            //密码错误
            throw new CbatRuntimeException(StatuCode.PWD_MISTAKE);
        }

    }
    @ApiOperation("用戶登出")
    @PostMapping(value = "/logout",name = "用戶登出")
    public void logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
