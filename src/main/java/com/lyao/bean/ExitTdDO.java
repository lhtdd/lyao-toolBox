package com.lyao.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ExitTdDO {
    private Long id;

    private String txId;

    private Byte mediaType;

    private String mediaNo;

    private Byte transPayType;

    private String tollProvinceId;

    private String issuerId;

    private Byte obuSign;

    private Byte identification;

    private String terminalTransNo;

    private String cardId;

    private Byte etcCardType;

    private Date exTime;

    private String vehicleId;

    private String identifyVehicleId;

    private String vehicleSignId;

    private Byte vehicleType;

    private Byte vehicleClass;

    private String TAC;

    private BigDecimal transFee;

    private String transType;

    private String terminalNo;

    private BigDecimal preBalance;

    private BigDecimal postBalance;

    private Short exWeight;

    private Byte axleCount;

    private String description;

    private String specialType;

    private String enTollLaneId;

    private String enTollLaneHex;

    private Date enTime;

    private Short enWeight;

    private Byte enAxleCount;

    private String enTollStationName;

    private String exTollStationName;

    private String exTollLaneId;

    private String passId;

    private String vehicleSign;

    private BigDecimal payFee;

    private BigDecimal fee;

    private Long discountFee;

    private Short noCardCount;

    private Integer feeMileage;

    private BigDecimal shortFee;

    private Integer shortFeeMileage;

    private BigDecimal feeRate;

    private Byte exitFeeType;

    private String spcRateVersion;

    private BigDecimal cardTotalAmount;

    private BigDecimal obuTotalAmount;

    private BigDecimal obuTotalDisCountAmount;

    private BigDecimal obuProvinceFee;

    private Short totalCount;

    private Short provTransCount;

    private Short provinceCount;

    private Byte discountType;

    private BigDecimal provinceDiscountFee;

    private BigDecimal originFee;

    private Byte accountStatus;

    private Date accountTime;

    private Byte result;

    private String resultDetail;

    private Byte uploadStatus;

    private Short refundstate;

    private Date refundtime;

    private String refundcardno;

    private String refundacctname;

    private Short refundcardtype;

    private Short refundtype;

    private Integer refundfailnum;

    private String refundbatchid;

    private String channel;

    private Integer chargebackid;

    private BigDecimal daikoufee;

    private String daikoutype;

    private String refundfailreason;

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

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(Byte mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaNo() {
        return mediaNo;
    }

    public void setMediaNo(String mediaNo) {
        this.mediaNo = mediaNo;
    }

    public Byte getTransPayType() {
        return transPayType;
    }

    public void setTransPayType(Byte transPayType) {
        this.transPayType = transPayType;
    }

    public String getTollProvinceId() {
        return tollProvinceId;
    }

    public void setTollProvinceId(String tollProvinceId) {
        this.tollProvinceId = tollProvinceId;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public Byte getObuSign() {
        return obuSign;
    }

    public void setObuSign(Byte obuSign) {
        this.obuSign = obuSign;
    }

    public Byte getIdentification() {
        return identification;
    }

    public void setIdentification(Byte identification) {
        this.identification = identification;
    }

    public String getTerminalTransNo() {
        return terminalTransNo;
    }

    public void setTerminalTransNo(String terminalTransNo) {
        this.terminalTransNo = terminalTransNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Byte getEtcCardType() {
        return etcCardType;
    }

    public void setEtcCardType(Byte etcCardType) {
        this.etcCardType = etcCardType;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getIdentifyVehicleId() {
        return identifyVehicleId;
    }

    public void setIdentifyVehicleId(String identifyVehicleId) {
        this.identifyVehicleId = identifyVehicleId;
    }

    public String getVehicleSignId() {
        return vehicleSignId;
    }

    public void setVehicleSignId(String vehicleSignId) {
        this.vehicleSignId = vehicleSignId;
    }

    public Byte getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Byte vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Byte getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(Byte vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getTAC() {
        return TAC;
    }

    public void setTAC(String TAC) {
        this.TAC = TAC;
    }

    public BigDecimal getTransFee() {
        return transFee;
    }

    public void setTransFee(BigDecimal transFee) {
        this.transFee = transFee;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public BigDecimal getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(BigDecimal preBalance) {
        this.preBalance = preBalance;
    }

    public BigDecimal getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(BigDecimal postBalance) {
        this.postBalance = postBalance;
    }

    public Short getExWeight() {
        return exWeight;
    }

    public void setExWeight(Short exWeight) {
        this.exWeight = exWeight;
    }

    public Byte getAxleCount() {
        return axleCount;
    }

    public void setAxleCount(Byte axleCount) {
        this.axleCount = axleCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getEnTollLaneId() {
        return enTollLaneId;
    }

    public void setEnTollLaneId(String enTollLaneId) {
        this.enTollLaneId = enTollLaneId;
    }

    public String getEnTollLaneHex() {
        return enTollLaneHex;
    }

    public void setEnTollLaneHex(String enTollLaneHex) {
        this.enTollLaneHex = enTollLaneHex;
    }

    public Date getEnTime() {
        return enTime;
    }

    public void setEnTime(Date enTime) {
        this.enTime = enTime;
    }

    public Short getEnWeight() {
        return enWeight;
    }

    public void setEnWeight(Short enWeight) {
        this.enWeight = enWeight;
    }

    public Byte getEnAxleCount() {
        return enAxleCount;
    }

    public void setEnAxleCount(Byte enAxleCount) {
        this.enAxleCount = enAxleCount;
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

    public String getExTollLaneId() {
        return exTollLaneId;
    }

    public void setExTollLaneId(String exTollLaneId) {
        this.exTollLaneId = exTollLaneId;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getVehicleSign() {
        return vehicleSign;
    }

    public void setVehicleSign(String vehicleSign) {
        this.vehicleSign = vehicleSign;
    }

    public BigDecimal getPayFee() {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Long getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Long discountFee) {
        this.discountFee = discountFee;
    }

    public Short getNoCardCount() {
        return noCardCount;
    }

    public void setNoCardCount(Short noCardCount) {
        this.noCardCount = noCardCount;
    }

    public Integer getFeeMileage() {
        return feeMileage;
    }

    public void setFeeMileage(Integer feeMileage) {
        this.feeMileage = feeMileage;
    }

    public BigDecimal getShortFee() {
        return shortFee;
    }

    public void setShortFee(BigDecimal shortFee) {
        this.shortFee = shortFee;
    }

    public Integer getShortFeeMileage() {
        return shortFeeMileage;
    }

    public void setShortFeeMileage(Integer shortFeeMileage) {
        this.shortFeeMileage = shortFeeMileage;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public Byte getExitFeeType() {
        return exitFeeType;
    }

    public void setExitFeeType(Byte exitFeeType) {
        this.exitFeeType = exitFeeType;
    }

    public String getSpcRateVersion() {
        return spcRateVersion;
    }

    public void setSpcRateVersion(String spcRateVersion) {
        this.spcRateVersion = spcRateVersion;
    }

    public BigDecimal getCardTotalAmount() {
        return cardTotalAmount;
    }

    public void setCardTotalAmount(BigDecimal cardTotalAmount) {
        this.cardTotalAmount = cardTotalAmount;
    }

    public BigDecimal getObuTotalAmount() {
        return obuTotalAmount;
    }

    public void setObuTotalAmount(BigDecimal obuTotalAmount) {
        this.obuTotalAmount = obuTotalAmount;
    }

    public BigDecimal getObuTotalDisCountAmount() {
        return obuTotalDisCountAmount;
    }

    public void setObuTotalDisCountAmount(BigDecimal obuTotalDisCountAmount) {
        this.obuTotalDisCountAmount = obuTotalDisCountAmount;
    }

    public BigDecimal getObuProvinceFee() {
        return obuProvinceFee;
    }

    public void setObuProvinceFee(BigDecimal obuProvinceFee) {
        this.obuProvinceFee = obuProvinceFee;
    }

    public Short getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Short totalCount) {
        this.totalCount = totalCount;
    }

    public Short getProvTransCount() {
        return provTransCount;
    }

    public void setProvTransCount(Short provTransCount) {
        this.provTransCount = provTransCount;
    }

    public Short getProvinceCount() {
        return provinceCount;
    }

    public void setProvinceCount(Short provinceCount) {
        this.provinceCount = provinceCount;
    }

    public Byte getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Byte discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getProvinceDiscountFee() {
        return provinceDiscountFee;
    }

    public void setProvinceDiscountFee(BigDecimal provinceDiscountFee) {
        this.provinceDiscountFee = provinceDiscountFee;
    }

    public BigDecimal getOriginFee() {
        return originFee;
    }

    public void setOriginFee(BigDecimal originFee) {
        this.originFee = originFee;
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public Byte getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Byte uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Short getRefundstate() {
        return refundstate;
    }

    public void setRefundstate(Short refundstate) {
        this.refundstate = refundstate;
    }

    public Date getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(Date refundtime) {
        this.refundtime = refundtime;
    }

    public String getRefundcardno() {
        return refundcardno;
    }

    public void setRefundcardno(String refundcardno) {
        this.refundcardno = refundcardno;
    }

    public String getRefundacctname() {
        return refundacctname;
    }

    public void setRefundacctname(String refundacctname) {
        this.refundacctname = refundacctname;
    }

    public Short getRefundcardtype() {
        return refundcardtype;
    }

    public void setRefundcardtype(Short refundcardtype) {
        this.refundcardtype = refundcardtype;
    }

    public Short getRefundtype() {
        return refundtype;
    }

    public void setRefundtype(Short refundtype) {
        this.refundtype = refundtype;
    }

    public Integer getRefundfailnum() {
        return refundfailnum;
    }

    public void setRefundfailnum(Integer refundfailnum) {
        this.refundfailnum = refundfailnum;
    }

    public String getRefundbatchid() {
        return refundbatchid;
    }

    public void setRefundbatchid(String refundbatchid) {
        this.refundbatchid = refundbatchid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getChargebackid() {
        return chargebackid;
    }

    public void setChargebackid(Integer chargebackid) {
        this.chargebackid = chargebackid;
    }

    public BigDecimal getDaikoufee() {
        return daikoufee;
    }

    public void setDaikoufee(BigDecimal daikoufee) {
        this.daikoufee = daikoufee;
    }

    public String getDaikoutype() {
        return daikoutype;
    }

    public void setDaikoutype(String daikoutype) {
        this.daikoutype = daikoutype;
    }

    public String getRefundfailreason() {
        return refundfailreason;
    }

    public void setRefundfailreason(String refundfailreason) {
        this.refundfailreason = refundfailreason;
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