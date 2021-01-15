package com.lyao.concurrent.disruptor;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;

/**
 * @author lyao
 * @date 2019/9/30 9:52
 * @description 生产者
 */
public class MessageProducer {

    // 将参数封装到类型中
    // 即objs到Message
    private final static EventTranslatorVararg<Message> translator = (message, seq, objs) -> message.setId((String)objs[0]);
    private final RingBuffer<Message> ringBuffer;

    public MessageProducer(RingBuffer<Message> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void producerNewMessage(String messageId) {
        this.ringBuffer.publishEvent(translator, messageId);
    }

}
