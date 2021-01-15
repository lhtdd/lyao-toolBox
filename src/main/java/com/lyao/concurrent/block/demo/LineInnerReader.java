package com.lyao.concurrent.block.demo;

import com.lyao.concurrent.block.InnerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author lyao
 * @date 2019/9/22 10:43
 * @description
 */
public class LineInnerReader extends InnerReader {

    private static final Logger LOG = LoggerFactory.getLogger(LineInnerReader.class);

    /** 一组数据大小 */
    private static final int GROUP_LIMIT = 1024;

    public LineInnerReader(BlockingQueue<List<String>> blockingQueue, String inputFileName, int maxQueueSize){
        super(blockingQueue, inputFileName, maxQueueSize);
    }

    @Override
    protected List<String> obtainDataFromFile(File file) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        List<String> dataGroup = new ArrayList<>(GROUP_LIMIT);
        while ((line = bufferedReader.readLine()) != null) {
            if (dataGroup.size() >= GROUP_LIMIT) {
                addDataGroup(dataGroup);
                // 数据重置
                dataGroup = new ArrayList<>(GROUP_LIMIT);
            }
            dataGroup.add(line);
        }
        bufferedReader.close();
        return dataGroup;
    }
}
