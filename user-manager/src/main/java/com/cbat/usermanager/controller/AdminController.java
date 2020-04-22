package com.cbat.usermanager.controller;


import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.Assert;
import com.cbat.exceptionhandler.util.ResponseUtil;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    IUserService userService;
    @Autowired
    IUserToRoleService userToRoleService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IPermisService permisService;
    @RequestMapping(value = "/login",name = "用戶登陆")
    public Response logIn(UserBean userBean){
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

    @RequestMapping(value = "/addUser",name = "添加用户")
    public Response addUser(UserBean userBean){
        userService.addUser(userBean);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/delUser",name = "删除用户")
    public Response delUser(String userId ){
        Assert.notEmpty(userId,"E00000005");
        userService.del(userId);
        return ResponseUtil.success();

    }

    @RequestMapping(value = "/updatePwd",name = "修改密码")
    public Response updateUser(UserBean userBean){
        Assert.notEmpty(userBean.getUserId(),"E00000005");
        userService.addUser(userBean);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/addRoleToUser",name = "给用户授予角色")
    public Response addRoleToUser(UserToRoleBean urBean){
        userToRoleService.add(urBean);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/addRolesToUser",name = "给用户批量授予角色")
    public Response addRolesToUser(List<UserToRoleBean> userToRoleBeans){
        userToRoleService.addAll(userToRoleBeans);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/findRolesByUserId",name = "查询用户的角色")
    public Response findRolesByUserId(String userId){
        Assert.notEmpty(userId,"E00000005");
        List<RoleBean> roles = roleService.findByUserId(userId);
        return ResponseUtil.success(roles);
    }
    @RequestMapping(value = "/findPermisesByUserId",name = "查询用户的权限")
    public Response findPermisesByUserId(String userId){
        Assert.notEmpty(userId,"E00000005");
        List<RoleBean> roles = roleService.findByUserId(userId);
        List<PermissionBean> permissions = new ArrayList<PermissionBean>();
        for (RoleBean r:roles) {
            List<PermissionBean> permises = permisService.getPermises(r.getRoleId());
            if(null!=permises&&0!=permises.size()){
                permissions.addAll(permises);
            }

        }
        return ResponseUtil.success(permissions);
    }


}
