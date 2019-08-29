package com.richur.venus.biz.impl;

import com.richur.venus.biz.model.po.User;
import com.richur.venus.biz.service.ExportExcelService;
import com.richur.venus.biz.util.ExcelUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/8/27 12:22 PM
 */
@Component
public class ExportExcelServiceImpl implements ExportExcelService {
    @Override
    public String exportExcel(HttpServletResponse response) {
        ExcelUtil.writeExcel(response, createUserList(), "用户", "一", new User());
        return "export excel";
    }

    private List<User> createUserList(){
        List<User> userList = new ArrayList<>();
        User user0 = new User(100001L,"richur1",1);
        User user1 = new User(100002L,"richur2",1);
        User user2 = new User(100003L,"richur3",1);
        User user3 = new User(100004L,"richur4",1);
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}
