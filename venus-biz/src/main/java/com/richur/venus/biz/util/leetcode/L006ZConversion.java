package com.richur.venus.biz.util.leetcode;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @Author richur
 * @Date 2019/10/16 8:53 PM
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 */
public class L006ZConversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        convert(s, numRows);
    }

    public static void convert(String s, int numRows) {

        char[] chars = s.toCharArray();
//        char[] newChar = new char[chars.length];
        String str = "";
        if(numRows == 1 || numRows == 2){
//            return s;
        }
        if(numRows == 2){
            for(int j=0; j<chars.length; j++){
                if(2*j >= chars.length){
                    break;
                }
                str +=chars[2*j];
            }
            for(int j=0; j<chars.length; j++){
                if(2*j+1 >= chars.length){
                    break;
                }
                str +=chars[2*j+1];
            }
        }

//        int count = 0;
        for(int i=0; i< numRows; i++){
            int flag = 0;
            int index = 0;
            for(int j=0; j<chars.length; j++){

                if(i == 0 || i == numRows-1){
                    index = i + j * 2 * (numRows-1);
                    if(index >= chars.length){
                        break;
                    } else {
//                        System.out.print(index);
//                        System.out.print(chars[index]);
                        str+=chars[index];

//                        newChar[count++]= chars[index];
//                        for(int t=0; t< numRows - 2; t++){
//                            System.out.print(" ");
//                        }
                    }
                } else {
                    if(index <= 0){
                        index = i;
                    } else {
                        flag = 2 * (numRows - 1) - flag;
                        index = flag + index;
                    }

                    if(index >= chars.length){
                        break;
                    }
                    for(int t = 0; t < flag-numRows +1; t++){
                        System.out.print(" ");
                    }
//                    System.out.print(chars[index]);
//                    newChar[count++] = chars[index];
                    str+=chars[index];
//                    System.out.print(index);


                    if(index < numRows){
                        flag = 2 * (numRows - i - 1);
                    } else {
                        flag = 2 * (numRows - 1) - flag;
                    }
                    index = flag + index;
                    if(index >= chars.length){
                        break;
                    }
//                    for(int t=0; t < flag-numRows+1; t++){
//                        System.out.print(" ");
//                    }
//                    System.out.print(index);
//                    System.out.print(chars[index]);
//                    newChar[count++] = chars[index];
                    str+=chars[index];
                }
            }
//            System.out.println();
        }
//        System.out.println(Arrays.toString(newChar));
        System.out.println(str);
//        return;
    }
}
