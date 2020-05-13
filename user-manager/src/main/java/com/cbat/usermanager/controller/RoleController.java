package com.cbat.usermanager.controller;



import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IRoleToPermisService;
import com.cbat.usermanager.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "角色控制")
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
    @ApiOperation("添加角色")
    @PostMapping(value = "/addRole",name = "添加角色")
    public void addRole(RoleBean roleBean){
        Assert.notEmpty(roleBean.getRoleName(),"角色名称不能为空");
        roleService.addRole(roleBean);
    }
    @ApiOperation("向角色添加权限")
    @PostMapping(value = "/addPermisToRole",name = "向角色添加权限")
    public void addPermisToRole(RoleToPermisBean roleToPermisBean){
        roleToPermisService.add(roleToPermisBean);
    }
    @ApiOperation("向角色批量添加权限")
    @PostMapping(value = "/addPermisesToRole",name = "向角色批量添加权限")
    public void addPermisesToRole(List<RoleToPermisBean> roleToPermises){
        roleToPermisService.addAll(roleToPermises);
    }
    @ApiOperation("删除角色")
    @PostMapping(value = "/delRole",name = "删除角色")
    public void delRole(@ApiParam("角色编号") String roleId){
        Assert.notEmpty(roleId,"角色编号不能为空");
        roleService.del(roleId);
    }
    @ApiOperation("查询角色所拥有的权限")
    @PostMapping(value = "/findPermisesByRoleId",name = "查询角色所拥有的权限")
    public List<PermissionBean> findPermisesByRoleId(@ApiParam("角色编号") String roleId){
        Assert.notEmpty(roleId,"角色编号不能为空");
        List<PermissionBean> permises = permisService.getPermises(roleId);
        return permises;
    }
    @ApiOperation("查询拥有该角色的所有用户")
    @PostMapping(value = "/findUsersByRoleId",name = "查询拥有该角色的所有用户")
    public List<UserBean> findUsersByRoleId(@ApiParam("角色编号") String roleId){
        Assert.notEmpty(roleId,"角色编号不能为空");
        List<UserBean> users = userService.getUsersByRoleId(roleId);
        return users;
    }

}
