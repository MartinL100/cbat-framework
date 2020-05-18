package com.cbat.monitor.util;

import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.config.CbatMonitorHandlerInterceptor;
import com.cbat.monitor.constans.VisitStatu;
import com.cbat.monitor.service.IVisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
@Component
public class CbatMonitorUtil {
    @Autowired
    private IVisitService visitService;
    private static CbatMonitorUtil cbatMonitorUtil;
    private static final Logger logger = LoggerFactory.getLogger(CbatMonitorUtil.class);

    /**
     * 修改记录为访问失败并记录异常信息
     * @param request
     * @param msg 异常信息
     */
    public static void updateMonitorToVisitFaile(HttpServletRequest request, String msg){
        try {
            VisitBean visitBean= (VisitBean) request.getAttribute(CbatMonitorHandlerInterceptor.VISIT_INFO);
            if (null!=visitBean){
                visitBean.setStatu(VisitStatu.FAILE);
                visitBean.setExpInfo(msg);
                visitBean.setLstModTime(new Timestamp(System.currentTimeMillis()));
                cbatMonitorUtil.visitService.update(visitBean);
            }
        } catch (Exception e) {
            logger.error("修改访问信息记录时出错",e);
        }
    }

    /**
     * 保存后台访问信息
     * @param request
     */
    public static void saveHandlerMethodMonitor(HttpServletRequest request){
        try {
            VisitBean visitInfo = cbatMonitorUtil.visitService.save(request);
            request.setAttribute(CbatMonitorHandlerInterceptor.VISIT_INFO,visitInfo);
        } catch (Exception e) {
            logger.error("保存后台访问信息时出错",e);
        }
    }

    /**
     * 保存访问页面信息
     * @param request
     */
    public static void saveViewMonitor(HttpServletRequest request){
        try {
            String path = request.getRequestURI();
            if (StringUtils.hasText(path)&&path.endsWith(".html")){
                VisitBean visitInfo = cbatMonitorUtil.visitService.savePage(request);
                request.setAttribute(CbatMonitorHandlerInterceptor.VISIT_INFO,visitInfo);
                return;
            }
        } catch (Exception e) {
            logger.error("保存后台访问信息时出错",e);
        }

    }


    @PostConstruct
    public void init(){
        cbatMonitorUtil = this;
    }
}
