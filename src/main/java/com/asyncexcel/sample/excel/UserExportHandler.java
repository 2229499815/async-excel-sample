package com.asyncexcel.sample.excel;

import com.asyncexcel.core.ExportPage;
import com.asyncexcel.core.annotation.ExcelHandle;
import com.asyncexcel.core.exporter.DataExportParam;
import com.asyncexcel.core.exporter.ExportHandler;
import com.asyncexcel.sample.entity.User;
import com.asyncexcel.sample.service.IUserService;
import com.asyncexcel.sample.util.ExportListUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author 姚仲杰#80998699
 * @Date 2022/8/26 16:03
 */
@ExcelHandle
public class UserExportHandler implements ExportHandler<UserExportModel> {
    
    @Autowired
    IUserService userService;
    @Override
    public ExportPage<UserExportModel> exportData(int startPage, int limit, DataExportParam dataExportParam) {
        IPage<User> iPage = new Page<>(startPage, limit);
        IPage page = userService.page(iPage);
        List<UserExportModel> list = ExportListUtil.transform(page.getRecords(), UserExportModel.class);
        ExportPage<UserExportModel> result = new ExportPage<>();
        result.setTotal(page.getTotal());
        result.setCurrent(page.getCurrent());
        result.setSize(page.getSize());
        result.setRecords(list);
        return result;
    }
}
