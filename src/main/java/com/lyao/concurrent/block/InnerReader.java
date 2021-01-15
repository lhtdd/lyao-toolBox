package com.lyao.concurrent.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lyao
 * @date 2019/9/21 16:50
 * @description
 */
public abstract class InnerReader implements Runnable {
    /** 阻塞队列 */
    private BlockingQueue<List<String>> blockingQueue;

    /** 输入文件名称 */
    private String inputFileName;

    /** 队列最大长度 */
    private int maxQueueSize;

    /** 结束标识 */
    private static final List<String> END = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(InnerReader.class);

    public InnerReader() {}

    public InnerReader(BlockingQueue<List<String>> blockingQueue, String inputFileName, int maxQueueSize) {
        this.blockingQueue = blockingQueue;
        this.inputFileName = inputFileName;
        this.maxQueueSize = maxQueueSize;
    }

    @Override
    public void run() {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            LOG.error("cat not find such file: {}", inputFileName);
            return;
        }
        try {
            List<String> dataGroup = obtainDataFromFile(inputFile);
            // 最后一批数据
            addDataGroup(dataGroup);
            // 结束标识
            addDataGroup(END);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    /**
     * 阻塞队列中加入数据: 队列满则等待
     *
     * @param dataGroup 一组数据
     * @throws Exception time.sleep
     */
    public void addDataGroup(List<String> dataGroup) throws Exception{
        while (blockingQueue.size() >= maxQueueSize) {
            TimeUnit.SECONDS.sleep(3);
        }
        blockingQueue.add(dataGroup);
    }

    protected abstract List<String> obtainDataFromFile(File file) throws Exception;

}
