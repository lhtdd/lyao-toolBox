package com.lyao.concurrent.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * @author lyao
 * @date 2019/9/30 10:01
 * @description
 * 有个理论性帖子
 * https://www.open-open.com/lib/view/open1479518365129.html
 * https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247484768&idx=1&sn=daa00d45f1e5b2ab8f5ef3b829267421&chksm=9bd0a8f8aca721ee56e098415868237d96f80e8c28dfecb577ba071e5e0fc540a013856bba3f&scene=27#wechat_redirect
 * https://mp.weixin.qq.com/s?__biz=MzAxODcyNjEzNQ==&mid=2247485923&idx=2&sn=8dbf11bd8c8c22a39f470d28ce6cdd53&chksm=9bd0a47baca72d6d56862d06904724b019879e42589d611c680b556371fffb5fdda91d591c68&scene=27#wechat_redirect
 * 有个基础应用的网址。
 * https://blog.csdn.net/weixin_37910453/article/details/88228412
 */
public class Main {
    public static void main(String[] args) {
        Disruptor<Message> disruptor = new Disruptor<>(Message::new, 1024, (ThreadFactory) Thread::new);
        // 设置消费者
        // 订阅模式 一条消息多个消费者
        /*disruptor.handleEventsWith(
                new MessageConsumerEventHandler(),
                new MessageConsumerEventHandler()
        );*/
        // work模式 一条消息一个消费者
        disruptor.handleEventsWithWorkerPool(
                new MessageConsumerWorkHandler(),
                new MessageConsumerWorkHandler()
        );
        disruptor.start();
        // 创建生产者
        RingBuffer<Message> ringBuffer = disruptor.getRingBuffer();
        MessageProducer producer = new MessageProducer(ringBuffer);
        for (int i = 0; i < 10; i++) {
            producer.producerNewMessage(String.valueOf(i));
        }
        disruptor.shutdown();
    }
}
