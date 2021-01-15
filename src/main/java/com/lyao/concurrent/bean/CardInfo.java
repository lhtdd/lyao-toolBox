package com.lyao.concurrent.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author lyao
 * @date 2019/9/22 16:23
 * @description
 */
@Data
public class CardInfo extends BaseRowModel{

    @ExcelProperty(index = 0, value = "车牌号")
    private String vlp;

}
