package com.cbat.usermanager.controller;



import com.cbat.exception.bean.response.PageQueryResponse;
import com.cbat.exception.util.Assert;
import com.cbat.usermanager.bean.PermissionBean;
import com.cbat.usermanager.bean.UserBean;
import com.cbat.usermanager.service.IPermisService;
import com.cbat.usermanager.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Api(tags = "资源控制")
@RestController
public class PermisController {
    @Autowired
    private IPermisService permisService;
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    IUserService userService;
    @ApiOperation("添加资源")
    @PostMapping(value = "/addPermis",name = "添加资源")
    public void addPermis(PermissionBean permissionBean){
        Assert.notEmpty(permissionBean.getPermissionName(),"资源名称不能为空");
        Assert.notEmpty(permissionBean.getPermissionUrl(),"资源路径不能为空");
        permisService.addPermis(permissionBean);
    }
    @ApiOperation("初始化资源")
    @PostMapping(value = "/initPermis",name = "初始化资源")
    public void initPermis() {
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
    }
    @ApiOperation("分页查看资源列表")
    @PostMapping(value = "/findPermis",name = "分页查看资源列表")
    public PageQueryResponse<PermissionBean> findPermis(PermissionBean permissionBean, @ApiParam("页码")int page, @ApiParam("每页显示条数")int size){
        Pageable pageable = PageRequest.of(page,size);
        PageQueryResponse<PermissionBean> permissions = permisService.pageQuery(permissionBean, pageable);
        return permissions ;
    }
    @ApiOperation("删除资源")
    @PostMapping(value = "/delPermis",name = "删除资源")
    public void delPermis(@ApiParam("资源编号")String permissionId){
        Assert.notEmpty(permissionId,"E00000002");
        permisService.del(permissionId);
    }
    @ApiOperation("查询拥有该权限的所有用户")
    @PostMapping(value = "/findUsersByPermisId",name = "查询拥有该权限的所有用户")
    public List<UserBean> findUsersByPermisId(@ApiParam("资源编号") String permissionId){
        Assert.notEmpty(permissionId,"许可编号不能为空");
        List<UserBean> users = userService.getUsersByPermissId(permissionId);
        return users;
    }
}
