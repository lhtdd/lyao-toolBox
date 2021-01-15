package com.lyao.concurrent.block.etc;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.lyao.concurrent.bean.CardInfo;
import com.lyao.concurrent.block.InnerReader;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author lyao
 * @date 2019/9/22 10:43
 * @description
 */
@Slf4j
public class CardInfoInnerReader extends InnerReader {

    /** 一组数据大小 */
    private static final int GROUP_LIMIT = 1024;

    public CardInfoInnerReader(BlockingQueue<List<String>> blockingQueue, String inputFileName, int maxQueueSize){
        super(blockingQueue, inputFileName, maxQueueSize);
    }

    @Override
    protected List<String> obtainDataFromFile(File file) throws Exception{
        List<String> dataGroup = new ArrayList<>(GROUP_LIMIT);
        InputStream fileStream = new FileInputStream(file);
        List<Object> dataList = EasyExcelFactory.read(fileStream, new Sheet(1,1, CardInfo.class));
        int error = 0;
        for (Object o : dataList) {
            if (o instanceof CardInfo) {
                CardInfo importEntity = (CardInfo) o;
                try {
                    dataGroup.add(importEntity.getVlp());
                } catch (Exception e) {
                    error++;
                    e.printStackTrace();
                    continue;
                }
            }
        }
        return dataGroup;
    }
}
