package com.cbat.monitor.service.impl;

import com.cbat.monitor.bean.VisitBean;
import com.cbat.monitor.constans.VisitStatu;
import com.cbat.monitor.constans.VisitType;
import com.cbat.monitor.dao.VisitRepository;
import com.cbat.monitor.service.IVisitService;
import com.cbat.monitor.util.IpAddressUtil;
import com.cbat.monitor.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.ParameterizableViewController;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

@Service
public class VisitServiceImpl implements IVisitService {
    @Autowired
    VisitRepository visitRepository;

    @Override
    public VisitBean save(HttpServletRequest request) {
        VisitBean visitBean = requestToBean(request);
        visitBean.setVisitType(VisitType.METHOD);
        return visitRepository.save(visitBean);
    }

    @Override
    public VisitBean savePage(HttpServletRequest request) {
            VisitBean visitBean = requestToBean(request);
            visitBean.setVisitType(VisitType.PAGE);
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

    private VisitBean requestToBean(HttpServletRequest request){
        String ip = IpAddressUtil.getIpAddress(request);
        Address address = IpAddressUtil.ipToArea(ip).getAddress();
        String path = request.getRequestURI();
        VisitBean visitBean = new VisitBean();
        visitBean.setVisitIp(ip);
        visitBean.setCity(address.getCity());
        visitBean.setRegion(address.getRegion());
        visitBean.setPath(path);
        visitBean.setVisitTime(new Date(System.currentTimeMillis()).toString());
        visitBean.setLstModTime(new Timestamp(System.currentTimeMillis()));
        visitBean.setStatu(VisitStatu.SUCCESS);
        return visitBean;
    }
}
