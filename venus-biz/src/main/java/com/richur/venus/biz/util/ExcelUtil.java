package com.richur.venus.biz.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author richur
 * @Date 2019/8/27 4:06 PM
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                          String fileName, String sheetName, BaseRowModel object){
        writeExcelWithHead(response, list, fileName, sheetName, object, null);
    }

    /**
     *
     * @param response
     * @param list
     * @param fileName
     * @param sheetName
     * @param object
     * @param headers
     */
    public static void writeExcelWithHead(HttpServletResponse response, List<? extends BaseRowModel> list,
                                          String fileName, String sheetName, BaseRowModel object, List<String> headers) {
        OutputStream outputStream = null;
        List<List<String>> head = new ArrayList<>();
        if(null != headers) {
            for (String header : headers) {
                List<String> item = new ArrayList<>();
                item.add(header);
                head.add(item);
            }
        }
        try {

            outputStream = getOutputStream(fileName, response);
            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLS);
            Sheet sheet = new Sheet(1, 0, object.getClass());
            if(null != headers){
                sheet.setHead(head);
            }
            TableStyle tableStyle = new TableStyle();
            Font headFont = new Font();
            Font contentFont = new Font();
            tableStyle.setTableHeadBackGroundColor(IndexedColors.GREY_25_PERCENT);
            tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);

            headFont.setFontHeightInPoints((short)12);
            headFont.setFontName("宋体");
            headFont.setBold(Boolean.TRUE);

            contentFont.setFontHeightInPoints((short)10);
            contentFont.setFontName("宋体");
            contentFont.setBold(Boolean.FALSE);
            tableStyle.setTableHeadFont(headFont);
            tableStyle.setTableContentFont(contentFont);

            sheet.setTableStyle(tableStyle);
            sheet.setSheetName(sheetName);
            writer.write(list, sheet);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream  getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        fileName = fileName + ".xls";
        try {
//            fileName = new String(filePath.getBytes(), "UTF-8");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
