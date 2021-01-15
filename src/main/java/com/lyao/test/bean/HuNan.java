package com.lyao.test.bean;
import java.util.Map;

/**
 * @author lyao
 * @date 2019/12/25 11:33
 * @description
 */
public class HuNan {
    private String cardNo;
    private Map<String, Object> respInfo;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Map<String, Object> getRespInfo() {
        return respInfo;
    }

    public void setRespInfo(Map<String, Object> respInfo) {
        this.respInfo = respInfo;
    }
}
