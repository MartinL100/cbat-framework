package com.cbat.usermanager.controller;


import com.cbat.exceptionhandler.bean.Response;
import com.cbat.exceptionhandler.util.Assert;
import com.cbat.exceptionhandler.util.ResponseUtil;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IRoleToPermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@RestController
public class PermisController {
    @Autowired
    private IPermisService permisService;
    @Autowired
    WebApplicationContext applicationContext;
    @RequestMapping(value = "/addPermis",name = "添加资源")
    public Response addPermis(PermissionBean permissionBean){
        Assert.notEmpty(permissionBean.getPermissionName(),"E00000008");
        Assert.notEmpty(permissionBean.getPermissionUrl(),"E00000009");
        permisService.addPermis(permissionBean);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/initPermis",name = "初始化资源")
    public Response initPermis() {
        List<PermissionBean> permissions = new ArrayList<PermissionBean>();
        RequestMappingHandlerMapping mapping =
                applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo,HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        Set<RequestMappingInfo> requestMappingInfos = handlerMethods.keySet();
        for (RequestMappingInfo r:requestMappingInfos) {
            PermissionBean permissionBean = new PermissionBean();
            permissionBean.setPermissionName(r.getName());
            String url = r.getPatternsCondition().toString();
            url.trim();
            url = url.substring(1,url.length()-1);
            permissionBean.setPermissionUrl(url);
            permissions.add(permissionBean);
        }
        permisService.addAll(permissions);
        return ResponseUtil.success();
    }
    @RequestMapping(value = "/findPermis",name = "分页查看资源列表")
    public Response findPermis(PermissionBean permissionBean,int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<PermissionBean> permissions = permisService.pageQuery(permissionBean, pageable);
        return ResponseUtil.success(permissions.toList(),permissions.getTotalElements());
    }

    @RequestMapping(value = "/delPermis",name = "删除资源")
    public Response delPermis(String permissionId){
        Assert.notEmpty(permissionId,"E00000002");

        permisService.del(permissionId);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/findUsersByPermisId",name = "查询拥有该权限的所有用户")
    public Response findUsersByPermisId(String permissionId){
        Assert.notEmpty(permissionId,"E00000002");
        //todo
        return ResponseUtil.success();
    }
}
