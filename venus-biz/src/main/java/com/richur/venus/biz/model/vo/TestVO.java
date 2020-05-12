package com.richur.venus.biz.model.vo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.*;

/**
 * @Author Richur
 * @Date 2019/12/3 6:25 下午
 */
@Setter
@Getter
public class TestVO implements Serializable {
    private static final long serialVersionUID = 6394525136517392801L;
    private Long jobId;                                     // 邮件任务id
    private String jobName;                                 // 邮件任务名
    private String url;                                     // 请求地址
    private Integer method;                                 // 请求方法
    private Map<String,String> params;                      // 请求参数
    private List<Long> parents;                             // 依赖任务

    private Integer jobType;                                // 作业类型
    private String jobDesc;


    public static void main(String[] args) {
        List<TestVO> list = new ArrayList<>();

        TestVO testVO1= new TestVO();
        TestVO testVO2= new TestVO();
        TestVO testVO3= new TestVO();
        testVO1.setJobId(3L);
        testVO2.setJobId(2L);
        testVO3.setJobId(1L);
        list.add(testVO1);
        list.add(testVO2);
        list.add(testVO3);



        Collections.sort(list, (o1, o2) -> {
            if ( o1.getJobId() > o2.getJobId()) {
//            if (o1 == null || o2 == null || o1.getJobId() == null || o2.getJobId() == null || o1.getJobId() > o2.getJobId()) {
                return 1;
            }
            System.out.println(o1.getJobId().compareTo(o2.getJobId()));
            return o1.getJobId().compareTo(o2.getJobId());

            //return -1;
        });
        list.forEach(l -> System.out.println(l.jobId));
        //System.out.println(list);


    }
}
