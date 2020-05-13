package com.cbat.monitor.controller;

import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.service.IVisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "网站监测")
@RestController
public class MonitorController {
    @Autowired
    IVisitService visitService;
    @ApiOperation("分页查看网站访问信息")
    @RequestMapping(value = "/getVists",name = "查看网站访问信息")
    public Page<VisitBean> getVists(VisitBean visitBean, @ApiParam("页码")int page, @ApiParam("每页显示条数")int size){
        return visitService.findVisitBeans(visitBean, PageRequest.of(page,size));
    }
}
