package com.cbat.usermanager.controller;

import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.bean.UserToRoleBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IUserService;
import com.cbat.usermanager.service.IUserToRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Api(tags = "用户控制")
@RestController
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IUserToRoleService userToRoleService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IPermisService permisService;

    @ApiOperation("添加用户")
    @PostMapping(value = "/addUser",name = "添加用户")
    public void addUser(UserBean userBean){
        userService.addUser(userBean);
    }
    @ApiOperation("删除用户")
    @PostMapping(value = "/delUser",name = "删除用户")
    public void delUser(@ApiParam("用户编号") String userId ){
        Assert.notEmpty(userId,"E00000005");
        userService.del(userId);

    }
    @ApiOperation("修改密码")
    @PostMapping(value = "/updatePwd",name = "修改密码")
    public void updateUser(UserBean userBean){
        Assert.notEmpty(userBean.getUserId(),"用户编号不能为空");
        userService.addUser(userBean);
    }
    @ApiOperation("给用户授予角色")
    @PostMapping(value = "/addRoleToUser",name = "给用户授予角色")
    public void addRoleToUser(UserToRoleBean urBean){
        userToRoleService.add(urBean);
    }
    @ApiOperation("给用户批量授予角色")
    @PostMapping(value = "/addRolesToUser",name = "给用户批量授予角色")
    public void addRolesToUser(List<UserToRoleBean> userToRoleBeans){
        userToRoleService.addAll(userToRoleBeans);
    }
    @ApiOperation("查询用户的角色")
    @PostMapping(value = "/findRolesByUserId",name = "查询用户的角色")
    public List<RoleBean> findRolesByUserId(@ApiParam("用户编号") String userId){
        Assert.notEmpty(userId,"用户编号不能为空");
        List<RoleBean> roles = roleService.findByUserId(userId);
        return roles;
    }
    @ApiOperation("查询用户的权限")
    @PostMapping(value = "/findPermisesByUserId",name = "查询用户的权限")
    public List<PermissionBean> findPermisesByUserId(@ApiParam("用户编号") String userId){
        Assert.notEmpty(userId,"用户编号不能为空");
        List<RoleBean> roles = roleService.findByUserId(userId);
        List<PermissionBean> permissions = new ArrayList<PermissionBean>();
        for (RoleBean r:roles) {
            List<PermissionBean> permises = permisService.getPermises(r.getRoleId());
            if(null!=permises&&0!=permises.size()){
                permissions.addAll(permises);
            }

        }
        return permissions;
    }


}
