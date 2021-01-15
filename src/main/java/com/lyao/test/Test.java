package com.lyao.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson.JSON;
import com.lyao.test.bean.HuNan;
import com.lyao.test.bean.Inner;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyao
 * @date 2018/7/9 14:35
 * @description
 */
public class Test {


    public static void main(String[] args) {
        String version = "2020-04-10";
        String a = version.replace("-", "");
        System.out.println(a);
    }

    private void fileTest(){
        String zipFile = "C:\\Users\\lenovo\\Desktop\\ETC办卡\\联合发卡\\内蒙古\\新建文件夹\\内蒙古.zip";
        String outFile = "C:\\Users\\lenovo\\Desktop\\ETC办卡\\联合发卡\\内蒙古\\新建文件夹\\123";
        File unzip = ZipUtil.unzip(zipFile, outFile);
        System.out.println(unzip);

        List<File> files = FileUtil.loopFiles(outFile);
        for (File file : files) {
            System.out.println(file.getName());
            String fileContent = FileUtil.readUtf8String(file);
            System.out.println(fileContent);
        }
        // 清空文件夹
        FileUtil.clean(outFile);
    }

    private void hunan(){
        Map<String, Object> testMap = new HashMap<>(16);
        Inner inner0 = new Inner();
        inner0.setCmdType(0);
        inner0.setCmdValue("fasdf123");
        Map<String, Inner> testMapInner = new HashMap<>(16);
        testMapInner.put("inner", inner0);
        testMap.put("0", testMapInner);
        Inner inner1 = new Inner();
        inner1.setCmdType(1);
        inner1.setCmdValue("7979454646sfadfg");
        Map<String, Inner> testMapInner1 = new HashMap<>(16);
        testMapInner1.put("inner", inner1);
        testMap.put("1", testMapInner1);


        HuNan huNan = new HuNan();
        huNan.setCardNo("4646546");
        huNan.setRespInfo(testMap);
        String jsonObject = JSON.toJSONString(huNan);
        System.out.println(jsonObject);

        HuNan huNan1 = JSON.parseObject(jsonObject, HuNan.class);
        System.out.println("df");
    }
}
