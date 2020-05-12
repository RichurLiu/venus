package com.richur.venus.web.study;

import com.richur.venus.biz.enums.TestTypeEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author richur
 * @since v0.0.1
 */
public class StudyTest {

    public static void main(String[] args) {

//        for(int i=1;i<=9;i++){
//            System.out.println(i);
//            readFile(i);
//
//        }
        System.out.println(TestTypeEnum.TEST.toString());
    }

    private static void readFile(int i){
        String name = "/Users/richur/Downloads/part-0000" + i;
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                String[] split = str.split(",");
                if(split.length != 11){
                    System.out.println("---"+str);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
