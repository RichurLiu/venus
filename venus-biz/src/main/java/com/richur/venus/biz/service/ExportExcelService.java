package com.richur.venus.biz.service;

import com.richur.venus.biz.model.po.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/8/27 12:22 PM
 */
public interface ExportExcelService {
    String exportExcel(HttpServletResponse response);
    List<User> getUserList();
}
