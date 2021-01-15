package com.lyao.concurrent.disruptor;

import com.lmax.disruptor.*;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author lyao
 * @date 2019/9/30 14:29
 * @description work模式，一个消息由一个消费者来消费
 * 这其实是Disruptor 类的自我实现，可查看Disruptor类源码
 */
public class Main2 {
    public static void main(String[] args) {
        RingBuffer<Message> ringBuffer = RingBuffer.createSingleProducer(Message::new, 2, new YieldingWaitStrategy());
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        WorkerPool<Message> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(),
                new MessageConsumerWorkHandler(),
                new MessageConsumerWorkHandler()
                );
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        //创建一个线程池用于执行Workhandler。
        Executor executor = Executors.newFixedThreadPool(4);
        //启动WorkPool
        workerPool.start(executor);
        //往RingBuffer上发布事件
        for (int i = 0; i < 8; i++) {
            final String id = String.valueOf(i);
            EventTranslator eventTranslator = (EventTranslator<Message>) (event, sequence) -> {
                event.setId(id);
            };
            ringBuffer.publishEvent(eventTranslator);
            System.out.println("发布[" + i + "]");
        }

    }
}
