package com.richur.venus.web.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.richur.venus.biz.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.richur.venus.biz.service.ExportExcelService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/8/27 10:32 AM
 */
@RestController
public class LoginController {

    @Autowired
    private ExportExcelService exportExcelService;

    @RequestMapping(value = "venus/login")
    public String login(){
        return "OK";
    }
    @RequestMapping(value = "venus/download")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){
        exportExcelService.exportExcel(response);

//        try {
//
//            ServletOutputStream out = response.getOutputStream();
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
//            String fileName = new String(("UserInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
//                    .getBytes(), "UTF-8");
//            Sheet sheet = new Sheet(1, 0, User.class);
//            sheet.setSheetName("用户");
//            writer.write(createUserList(),sheet);
////            writer.write0(getListString(), sheet1);
//            writer.finish();
////            response.setContentType("multipart/form-data");
//            response.setContentType( "application/vnd.ms-excel" );
//            response.setCharacterEncoding("utf-8");
//            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode( fileName + ".xlsx", "utf-8" ));
//            out.flush();
//            System.out.println(fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
