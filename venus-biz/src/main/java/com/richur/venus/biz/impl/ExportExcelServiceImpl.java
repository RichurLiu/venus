package com.richur.venus.biz.impl;

import com.richur.venus.biz.aspect.annotation.CommonLog;
import com.richur.venus.biz.model.po.User;
import com.richur.venus.biz.service.ExportExcelService;
import com.richur.venus.biz.util.ExcelUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/8/27 12:22 PM
 */
@Component
public class ExportExcelServiceImpl implements ExportExcelService {
    private static final DecimalFormat df1 = new DecimalFormat("#,###");
    private static final DecimalFormat df2 = new DecimalFormat("0.##");
    @Override
    public String exportExcel(HttpServletResponse response) {
        ExcelUtil.writeExcel(response, createUserList(), "用户", "一", new User());
        return "export excel";
    }
    @CommonLog(detail="测试", level = 2)
    @Override
    public List<User> getUserList(){
        return createUserList();
    }

    private List<User> createUserList(){
        List<User> userList = new ArrayList<>();
        User user0 = new User(10000111111L,df1.format(10000111111L),1);
        User user1 = new User(10011111002L,df1.format(10000111121L),1);
        User user2 = new User(10111110003L,df2.format(10000111.121),1);
        User user3 = new User(10011111004L,"richur4",1);
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
