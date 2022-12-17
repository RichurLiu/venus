package com.richur.venus.biz.util.leetcode;

/**
 * https://www.bilibili.com/video/BV1vi4y1R7g9?p=2
 *
 * 给定一个有序的数组arr，代表落在x轴上的点，给定一个正整数K，代表绳子的长度
 * 绳子最多可以压中多少个点？
 */
public class MaxPoint {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,7,10,11,12,13,15};
        int N = 5;
        System.out.println(maxPoint(arr, N));
    }

    public static int maxPoint(int[] arr, int N) {
        int left = 0;
        int right = 0;
        int max = 0;
        int L = arr.length;
        while(left < L) {
            while(right < L && arr[right] - arr[left] <= N) {
                right ++;
            }
            right --;
            System.out.println(""+arr[left] +","+arr[right] +"");
            System.out.println("("+left+","+right+")");
            max = Math.max(max , right - left + 1);
            left ++;
        }
        return max;
    }
}
