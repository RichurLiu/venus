package com.richur.venus.biz.util.file;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileOperate {

    public static void main(String[] args) throws IOException{

        readFileByLines("/Users/richur/Downloads/0619aaa.csv");
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) throws IOException{
        File file = new File(fileName);
        BufferedReader reader = null;
        Map<String, String> map = new HashMap<>(10240);
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号

                String[] split = tempString.split(",");
                map.put(split[0], tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }


        System.out.println(map.size());
        FileWriter writer = new FileWriter("/Users/richur/Downloads/0619bbb.csv", true);
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            writer.write(stringStringEntry.getValue());
            writer.write("\n");
        }
        writer.close();
    }


    /**
     * B方法追加文件：使用FileWriter
     */
    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
