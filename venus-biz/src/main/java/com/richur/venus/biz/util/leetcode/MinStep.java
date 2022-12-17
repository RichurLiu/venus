package com.richur.venus.biz.util.leetcode;

/**
 *  https://www.bilibili.com/video/BV1vi4y1R7g9?p=2
 *  一个数组中只有两种字符G和B，想让所有的G都放在左侧，所有的B都放在右侧，只可以相邻字符之间进行操作
 *  至少需要交换几次？
 */
public class MinStep {
    public static void main(String[] args) {
        char[] arr = new char[]{'G','B','G','B','G','B'};
        System.out.println(minStep(arr));
    }

    public static int minStep(char[] arr) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'G') {
                res += i - count;
                count ++;
            }
        }
        return res;
    }
}
