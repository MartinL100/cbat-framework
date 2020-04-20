package com.cbat.usermanager.controller;


import com.cbat.exceptionhandler.util.Assert;
import com.cbat.usermanager.bean.RoleBean;
import com.cbat.usermanager.bean.RoleToPermisBean;
import com.cbat.usermanager.service.IRoleService;
import com.cbat.usermanager.service.IRoleToPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    IRoleToPermisService roleToPermisService;
    @RequestMapping("/addRole")
    public void addRole(RoleBean roleBean){
        Assert.notEmpty(roleBean.getRoleName(),"角色名称不能为空");
        roleService.addRole(roleBean);
    }
    @RequestMapping("/addPermisToRole")
    public void addPermisToRole(RoleToPermisBean roleToPermisBean){
        roleToPermisService.add(roleToPermisBean);
    }
}
