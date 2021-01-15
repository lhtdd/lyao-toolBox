package com.lyao.concurrent.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author lyao
 * @date 2019/9/30 9:57
 * @description 消费者
 */
public class MessageConsumerEventHandler implements EventHandler<Message> {

    @Override
    public void onEvent(Message message, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("线程"+Thread.currentThread().getName()+"收到消息 " + message);
    }
}
