package com.lyao.concurrent.block.demo;

import com.lyao.concurrent.block.InnerWriter;
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
public class LineInnerWriter extends InnerWriter {

    private static final Logger LOG = LoggerFactory.getLogger(LineInnerWriter.class);
    /** 输出文件名 */
    private String outputFileName = "E:\\current.txt";

    public LineInnerWriter(BlockingQueue<List<String>> blockingQueue) {
        super(blockingQueue);
    }

    @Override
    protected void dealData(List<String> dataGroup) throws Exception {
        String output = String.format("%s.%s", outputFileName, Thread.currentThread().getId());
        File outputFile = new File(output);
        FileWriter writer = new FileWriter(outputFile);
        for (String line : dataGroup) {
            writer.write(String.format("%s\t%s\n", line, line.length()));
        }
        writer.close();
    }
}
