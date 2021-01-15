package com.lyao.test.bean;

/**
 * @author lyao
 * @date 2019/12/16 10:59
 * @description
 */
public class Transaction {

    private int tradeType;

    private String id;

    private int payFee;

    private int fee;

    private int discountFee;

    private int mediaType;

    private String obuId;

    private String cardId;

    private String transTime;

    private String vehicleId;

    private int vehicleType;

    private int serviceType;

    private String description;

    private String passId;

    public void setTradeType(int tradeType){
        this.tradeType = tradeType;
    }
    public int getTradeType(){
        return this.tradeType;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setPayFee(int payFee){
        this.payFee = payFee;
    }
    public int getPayFee(){
        return this.payFee;
    }
    public void setFee(int fee){
        this.fee = fee;
    }
    public int getFee(){
        return this.fee;
    }
    public void setDiscountFee(int discountFee){
        this.discountFee = discountFee;
    }
    public int getDiscountFee(){
        return this.discountFee;
    }
    public void setMediaType(int mediaType){
        this.mediaType = mediaType;
    }
    public int getMediaType(){
        return this.mediaType;
    }
    public void setObuId(String obuId){
        this.obuId = obuId;
    }
    public String getObuId(){
        return this.obuId;
    }
    public void setCardId(String cardId){
        this.cardId = cardId;
    }
    public String getCardId(){
        return this.cardId;
    }
    public void setTransTime(String transTime){
        this.transTime = transTime;
    }
    public String getTransTime(){
        return this.transTime;
    }
    public void setVehicleId(String vehicleId){
        this.vehicleId = vehicleId;
    }
    public String getVehicleId(){
        return this.vehicleId;
    }
    public void setVehicleType(int vehicleType){
        this.vehicleType = vehicleType;
    }
    public int getVehicleType(){
        return this.vehicleType;
    }
    public void setServiceType(int serviceType){
        this.serviceType = serviceType;
    }
    public int getServiceType(){
        return this.serviceType;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setPassId(String passId){
        this.passId = passId;
    }
    public String getPassId(){
        return this.passId;
    }
}
