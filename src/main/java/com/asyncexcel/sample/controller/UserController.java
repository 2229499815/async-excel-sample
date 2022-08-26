package com.asyncexcel.sample.controller;

import com.asyncexcel.core.exporter.DataExportParam;
import com.asyncexcel.core.importer.DataImportParam;
import com.asyncexcel.sample.excel.UserExportHandler;
import com.asyncexcel.sample.excel.UserExportModel;
import com.asyncexcel.sample.excel.UserImportHandler;
import com.asyncexcel.sample.excel.UserImportModel;
import com.asyncexcel.springboot.ExcelService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 姚仲杰
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    ExcelService excelService;

    //导入最简示例
    @PostMapping("/imports")
    public Long imports(@RequestBody MultipartFile file) throws Exception{
        DataImportParam dataImportParam = new DataImportParam()
            .setStream(file.getInputStream())
            .setModel(UserImportModel.class)
            .setBatchSize(3);
        Long taskId = excelService.doImport(UserImportHandler.class, dataImportParam);
        return taskId;
    }
    
    //导出最简示例
    @PostMapping("/exports")
    public Long exports(){
        DataExportParam dataExportParam=new DataExportParam()
            .setExportFileName("用户导出")
            .setLimit(5)
            .setHeadClass(UserExportModel.class);
        return excelService.doExport(UserExportHandler.class,dataExportParam);
    }
    
}
