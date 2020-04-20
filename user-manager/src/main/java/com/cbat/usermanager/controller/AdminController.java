package com.cbat.usermanager.controller;


import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import com.cbat.usermanager.service.IUserService;
import com.cbat.usermanager.service.IUserToRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    IUserService userService;
    @Autowired
    IUserToRoleService userToRoleService;
    @RequestMapping("/login")
    public String logIn(UserBean userBean){
        String info = "登陆成功";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getUserName(),userBean.getPwd());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            //
            info = "用户名不存在";
        }catch (IncorrectCredentialsException e) {
            //
            info = "密码错误";
        }

        return info;
    }
    @RequestMapping("/logout")
    public String logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "登出成功";
    }

    @RequestMapping("/addUser")
    public void addUser(UserBean userBean){
        userService.addUser(userBean);
    }

    @RequestMapping("/delUser")
    public String delUser(UserBean userBean){
        return "删除成功";
    }

    @RequestMapping("/updatePwd")
    public void updateUser(UserBean userBean){

    }
    @RequestMapping("/addRoleToUser")
    public void addRoleToUser(UserToRoleBean urBean){
        userToRoleService.add(urBean);
    }

}
