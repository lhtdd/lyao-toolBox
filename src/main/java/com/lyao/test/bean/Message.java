package com.lyao.test.bean;

import java.util.List;

/**
 * @author lyao
 * @date 2019/12/16 10:58
 * @description
 */
public class Message {

    private String orgid;

    private int messageid;

    private int count;

    private int amount;

    private List<Transaction> transaction;

    public void setOrgid(String orgid){
        this.orgid = orgid;
    }
    public String getOrgid(){
        return this.orgid;
    }
    public void setMessageid(int messageid){
        this.messageid = messageid;
    }
    public int getMessageid(){
        return this.messageid;
    }
    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return this.amount;
    }
    public void setTransaction(List<Transaction> transaction){
        this.transaction = transaction;
    }
    public List<Transaction> getTransaction(){
        return this.transaction;
    }
}
