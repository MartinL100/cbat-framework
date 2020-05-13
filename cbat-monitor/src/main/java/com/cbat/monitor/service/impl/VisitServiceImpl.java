package com.cbat.monitor.service.impl;

import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.constans.VisitStatu;
import com.cbat.monitor.dao.VisitRepository;
import com.cbat.monitor.service.IVisitService;
import com.cbat.monitor.util.IpAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

@Service
public class VisitServiceImpl implements IVisitService {
    @Autowired
    VisitRepository visitRepository;

    @Override
//    @Async("asyncLogExecutor")
    public VisitBean save(HttpServletRequest request) {
        String ip = IpAddressUtil.getIpAddress(request);
        String area = IpAddressUtil.ipToArea(ip);
        String path = request.getRequestURI();
        VisitBean visitBean = new VisitBean();
        visitBean.setVisitIp(ip);
        visitBean.setVisitArea(area);
        visitBean.setPath(path);
        visitBean.setVisitTime(new Date(System.currentTimeMillis()).toString());
        visitBean.setLstModTime(new Timestamp(System.currentTimeMillis()));
        visitBean.setStatu(VisitStatu.SUCCESS);
        return visitRepository.save(visitBean);
    }

    @Override
    public Page<VisitBean> findVisitBeans(VisitBean visitBean, Pageable pageable) {
        Example<VisitBean> example = Example.of(visitBean);
        return visitRepository.findAll(example,pageable);
    }

    @Override
    public VisitBean update(VisitBean visitBean) {
        return visitRepository.save(visitBean);
    }
}
