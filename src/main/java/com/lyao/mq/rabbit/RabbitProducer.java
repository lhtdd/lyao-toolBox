package com.lyao.mq.rabbit;

/**
 * @author lyao
 * @date 2019/9/15 16:40
 * @description
 */
public class RabbitProducer {

    public static void main(String[] args) {
        String s = "1970-01-01-00.00.00 港沟入，2019-09-14-09.14.10 淄博出 总重1.70吨 超限率0.0%";
        System.out.println(s);
        System.out.println(s.replace("%", ""));
    }
}
