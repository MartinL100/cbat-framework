package com.cbat.monitor.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Timestamp;
@ApiModel("访问信息表")
@Entity
@Table(name = "t_visit")
public class VisitBean {
    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(strategy = "uuid",name = "uid")
    @Column(length = 32)
    @ApiModelProperty("访问编号")
    private String visitId;
    @ApiModelProperty("访问IP")
    private String visitIp;
    @ApiModelProperty("访问省份")
    private String region;
    @ApiModelProperty("访问城市")
    private String city;
    @Transient
    @ApiModelProperty("访问时间查询起点")
    private String visitStartTime;
    @Transient
    @ApiModelProperty("访问时间查询终点")
    private String visitEndTime;
    @ApiModelProperty("访问时间")
    private String visitTime;
    @ApiModelProperty("访问状态")
    private String statu;
    @ApiModelProperty("访问类型")
    private String visitType;
    @ApiModelProperty("异常信息")
    private String expInfo;
    @ApiModelProperty("访问路径")
    private String path;
    @ApiModelProperty("最后修改时间")
    private Timestamp lstModTime;

    public String getVisitStartTime() {
        return visitStartTime;
    }

    public void setVisitStartTime(String visitStartTime) {
        this.visitStartTime = visitStartTime;
    }

    public String getVisitEndTime() {
        return visitEndTime;
    }

    public void setVisitEndTime(String visitEndTime) {
        this.visitEndTime = visitEndTime;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getExpInfo() {
        return expInfo;
    }

    public void setExpInfo(String expInfo) {
        this.expInfo = expInfo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getLstModTime() {
        return lstModTime;
    }

    public void setLstModTime(Timestamp lstModTime) {
        this.lstModTime = lstModTime;
    }
}
