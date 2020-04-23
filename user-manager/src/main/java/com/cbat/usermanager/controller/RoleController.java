package com.cbat.usermanager.controller;


import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.Assert;
import com.cbat.exceptionhandler.util.ResponseUtil;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IRoleToPermisService;
import com.cbat.usermanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    IPermisService permisService;
    @Autowired
    IRoleToPermisService roleToPermisService;
    @Autowired
    IUserService userService;
    @RequestMapping(value = "/addRole",name = "添加角色")
    public Response addRole(RoleBean roleBean){
        Assert.notEmpty(roleBean.getRoleName(),"E00000010");
        roleService.addRole(roleBean);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/addPermisToRole",name = "向角色添加权限")
    public Response addPermisToRole(RoleToPermisBean roleToPermisBean){
        roleToPermisService.add(roleToPermisBean);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/addPermisesToRole",name = "向角色批量添加权限")
    public Response addPermisesToRole(List<RoleToPermisBean> roleToPermises){
        roleToPermisService.addAll(roleToPermises);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/delRole",name = "删除角色")
    public Response delRole(String roleId){
        Assert.notEmpty(roleId,"E00000001");
        roleService.del(roleId);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/findPermisesByRoleId",name = "查询角色所拥有的权限")
    public Response findPermisesByRoleId(String roleId){
        Assert.notEmpty(roleId,"E00000001");
        List<PermissionBean> permises = permisService.getPermises(roleId);
        return ResponseUtil.success(permises);
    }
    @RequestMapping(value = "/findUsersByRoleId",name = "查询拥有该角色的所有用户")
    public Response findUsersByRoleId(String roleId){
        Assert.notEmpty(roleId,"E00000001");
        List<UserBean> users = userService.getUsersByRoleId(roleId);
        return ResponseUtil.success(users);
    }

}
