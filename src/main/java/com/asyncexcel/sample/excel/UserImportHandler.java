package com.asyncexcel.sample.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.asyncexcel.core.DataParam;
import com.asyncexcel.core.ErrorMsg;
import com.asyncexcel.core.ExcelContext;
import com.asyncexcel.core.annotation.ExcelHandle;
import com.asyncexcel.core.importer.DataImportParam;
import com.asyncexcel.core.importer.ImportContext;
import com.asyncexcel.core.importer.ImportHandler;
import com.asyncexcel.sample.entity.User;
import com.asyncexcel.sample.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @Description TODO
 * @Author 姚仲杰#80998699
 * @Date 2022/8/26 16:03
 */
@ExcelHandle
public class UserImportHandler implements ImportHandler<UserImportModel> {
    
    @Autowired
    IUserService userService;

    @Override
    public void init(ExcelContext ctx, DataParam param) {
        ReadSheet readSheet= EasyExcel.readSheet().sheetNo(0).headRowNumber(2).build();
        ImportContext impCtx=(ImportContext) ctx;
        impCtx.setReadSheet(readSheet);
    }

    @Override
    public List<ErrorMsg> importData(List<UserImportModel> list, DataImportParam dataImportParam)
        throws Exception {
        List<ErrorMsg> errorList=new ArrayList<>();
        List<User> saveUsers=new ArrayList<>();
        for (UserImportModel userImportModel : list) {
            if (userImportModel.getMobile().contains("00000000")){
                ErrorMsg msg = new ErrorMsg(userImportModel.getRow(), "手机号包含太多0");
                errorList.add(msg);
            }else{
                BeanCopier beanCopier = BeanCopier.create(UserImportModel.class, User.class, false);
                User user = new User();
                beanCopier.copy(userImportModel,user,null);
                saveUsers.add(user);
            }
        }
        userService.saveBatch(saveUsers);
        return errorList;
    }
}
