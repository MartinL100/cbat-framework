package com.cbat.monitor.dao;

import com.cbat.monitor.bean.VisitBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository()
public interface VisitRepository extends JpaRepository<VisitBean,String>{
}
