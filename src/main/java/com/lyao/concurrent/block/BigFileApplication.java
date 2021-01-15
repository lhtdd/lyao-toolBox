package com.lyao.concurrent.block;

import com.lyao.concurrent.block.demo.LineInnerReader;
import com.lyao.concurrent.block.demo.LineInnerWriter;
import com.lyao.concurrent.block.etc.CardInfoInnerReader;
import com.lyao.concurrent.block.etc.CardInfoInnerWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author lyao
 * @date 2019/9/21 16:56
 * @description
 */
public class BigFileApplication {

    private static final int DEFAULT_QUEUE_SIZE = 30;
    private static final Logger LOG = LoggerFactory.getLogger(BigFileApplication.class);

    public static void main(String[] args) {
        /*if (args == null || args.length < 1) {
            LOG.error("请提供输入文件和输出文件名称");
            return;
        }*/
        try {
            //executor(args[0]);
            executor("E:\\card_list.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("执行器错误. {}", e.getMessage());
        }


    }

    private static void executor(String inputFile) throws Exception {
        BlockingQueue<List<String>> blockingQueue = new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE);
        ThreadPoolExecutor pools = getThreadPool();
        pools.execute(new CardInfoInnerReader(blockingQueue, inputFile, DEFAULT_QUEUE_SIZE));
        while (true) {
            if (blockingQueue.isEmpty()) {
                TimeUnit.SECONDS.sleep(1);
            }

            List<String> dataGroup = blockingQueue.peek();
            if (dataGroup != null && dataGroup.isEmpty()) {
                LOG.info("process the big file done.");
                break;
            }
            pools.execute(new CardInfoInnerWriter(blockingQueue));
        }
        pools.shutdown();
    }

    /**
     * 定义线程池
     *      TODO: 相关配置加入配置文件
     *
     * @return 线程池
     */
    private static ThreadPoolExecutor getThreadPool() {
        return new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
