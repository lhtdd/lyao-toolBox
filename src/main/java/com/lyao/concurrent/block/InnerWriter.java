package com.lyao.concurrent.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author lyao
 * @date 2019/9/21 16:54
 * @description
 */
public abstract class InnerWriter implements Runnable{
    /** 阻塞队列 */
    private BlockingQueue<List<String>> blockingQueue;



    /** 结束标识 */
    private static final List<String> END = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(InnerWriter.class);
    public InnerWriter() {}

    public InnerWriter(BlockingQueue<List<String>> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        List<String> dataGroup = blockingQueue.poll();
        if (dataGroup == null) {
            return;
        }
        // 读取到结束标识， 重新入队
        if (dataGroup.isEmpty()) {
            blockingQueue.add(END);
            return;
        }
        try {
            dealData(dataGroup);
        } catch (Exception e) {
            LOG.error("执行异常", e);
        }finally {
            dataGroup.clear();
        }
    }

    protected abstract void dealData(List<String> dataGroup) throws Exception;
}
