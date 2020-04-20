package com.cbat.usermanager.controller;


import com.cbat.exceptionhandler.util.Assert;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.service.IPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermisController {
    @Autowired
    private IPermisService permisService;
    @RequestMapping("/addPermis")
    public void addPermis(PermissionBean permissionBean){
        Assert.notEmpty(permissionBean.getPermissionName(),"资源名称不能为空");
        Assert.notEmpty(permissionBean.getPermissionUrl(),"资源路径不能为空");
        permisService.addPermis(permissionBean);
    }
}
