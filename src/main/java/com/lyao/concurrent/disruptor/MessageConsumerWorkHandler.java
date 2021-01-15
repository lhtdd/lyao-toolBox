package com.lyao.concurrent.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * @author lyao
 * @date 2019/9/30 10:46
 * @description
 */
public class MessageConsumerWorkHandler implements WorkHandler<Message> {
    @Override
    public void onEvent(Message message) throws Exception {
        System.out.println("线程"+Thread.currentThread().getName()+"收到消息 " + message);
    }
}
