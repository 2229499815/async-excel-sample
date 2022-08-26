package com.asyncexcel.sample.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.asyncexcel.core.ExportRow;
import lombok.Data;

/**
 * @Description TODO
 * @Author 姚仲杰#80998699
 * @Date 2022/8/26 16:04
 */
@Data
public class UserExportModel extends ExportRow {
    
    @ExcelProperty("用户编码")
    private String userCode;
    
    @ExcelProperty("用户姓名")
    private String userName;
    
    @ExcelProperty("手机号")
    private String mobile;
    
    @ExcelProperty("备注")
    private String remarks;

}
