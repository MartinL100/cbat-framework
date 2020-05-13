package com.cbat.monitor.service;

import com.cbat.monitor.bean.VisitBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

public interface IVisitService {
    /**
     * 将request的封装为VisitBean并保存
     * 记录访问信息
     * @param request mvc请求
     */
    VisitBean save(HttpServletRequest request);

    /**
     * 动态查询访问信息集合
     * @param visitBean 查询条件
     * @return
     */
    Page<VisitBean> findVisitBeans(VisitBean visitBean, Pageable pageable);

    /**
     *
     * @param visitBean
     */
    VisitBean update(VisitBean visitBean);
}
