package com.lyao.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ExitTdDetailDO {
    private Long id;

    private Long tdId;

    private String txId;

    private String serProvinceId;

    private BigDecimal tollFee;

    private String enPointId;

    private String exPointId;

    private String enTollStationName;

    private String exTollStationName;

    private Date enTime;

    private Date exTime;

    private String tollIntervals;

    private String tollIntervalChargefee;

    private String tollIntervalPayFee;

    private String tollIntervalDiscountFee;

    private String tollIntervalRateVersion;

    private Boolean is_deleted;

    private Date gmt_create;

    private Date gmt_modified;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTdId() {
        return tdId;
    }

    public void setTdId(Long tdId) {
        this.tdId = tdId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getSerProvinceId() {
        return serProvinceId;
    }

    public void setSerProvinceId(String serProvinceId) {
        this.serProvinceId = serProvinceId;
    }

    public BigDecimal getTollFee() {
        return tollFee;
    }

    public void setTollFee(BigDecimal tollFee) {
        this.tollFee = tollFee;
    }

    public String getEnPointId() {
        return enPointId;
    }

    public void setEnPointId(String enPointId) {
        this.enPointId = enPointId;
    }

    public String getExPointId() {
        return exPointId;
    }

    public void setExPointId(String exPointId) {
        this.exPointId = exPointId;
    }

    public String getEnTollStationName() {
        return enTollStationName;
    }

    public void setEnTollStationName(String enTollStationName) {
        this.enTollStationName = enTollStationName;
    }

    public String getExTollStationName() {
        return exTollStationName;
    }

    public void setExTollStationName(String exTollStationName) {
        this.exTollStationName = exTollStationName;
    }

    public Date getEnTime() {
        return enTime;
    }

    public void setEnTime(Date enTime) {
        this.enTime = enTime;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }

    public String getTollIntervals() {
        return tollIntervals;
    }

    public void setTollIntervals(String tollIntervals) {
        this.tollIntervals = tollIntervals;
    }

    public String getTollIntervalChargefee() {
        return tollIntervalChargefee;
    }

    public void setTollIntervalChargefee(String tollIntervalChargefee) {
        this.tollIntervalChargefee = tollIntervalChargefee;
    }

    public String getTollIntervalPayFee() {
        return tollIntervalPayFee;
    }

    public void setTollIntervalPayFee(String tollIntervalPayFee) {
        this.tollIntervalPayFee = tollIntervalPayFee;
    }

    public String getTollIntervalDiscountFee() {
        return tollIntervalDiscountFee;
    }

    public void setTollIntervalDiscountFee(String tollIntervalDiscountFee) {
        this.tollIntervalDiscountFee = tollIntervalDiscountFee;
    }

    public String getTollIntervalRateVersion() {
        return tollIntervalRateVersion;
    }

    public void setTollIntervalRateVersion(String tollIntervalRateVersion) {
        this.tollIntervalRateVersion = tollIntervalRateVersion;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}