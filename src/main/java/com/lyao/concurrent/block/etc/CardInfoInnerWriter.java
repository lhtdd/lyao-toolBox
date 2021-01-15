package com.lyao.concurrent.block.etc;

import com.lyao.concurrent.block.InnerWriter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author lyao
 * @date 2019/9/22 10:58
 * @description
 */
@Slf4j
public class CardInfoInnerWriter extends InnerWriter {

    /** 输出文件名 */
    private String outputFileName = "E:\\current.txt";

    public CardInfoInnerWriter(BlockingQueue<List<String>> blockingQueue) {
        super(blockingQueue);
    }

    @Override
    protected void dealData(List<String> dataGroup) throws Exception {
        for (String vlp : dataGroup) {
            System.out.println(vlp);
        }
    }
}
