package com.richur.venus.biz.util.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author richur
 * @Date 2019/8/28 10:03 AM
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class LC001TwoSum {
    public static void main(String[] args) {
        LC001TwoSum obj = new LC001TwoSum();
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 17;
        int[] res = obj.twoSum(num, target);
        if (res[0] == 0 && res[1] == 0) {
            System.out.println("no match");
        } else {
            System.out.println("[" + res[0] + "," + res[1] + "]");
            System.out.println(num[res[0]] + "," + num[res[1]]);
        }
        res = obj.twoSum2(num, target);
        if (res[0] == 0 && res[1] == 0) {
            System.out.println("no match");
        } else {
            System.out.println("[" + res[0] + "," + res[1] + "]");
            System.out.println(num[res[0]] + "," + num[res[1]]);
        }
    }

    private int[] twoSum(int[] num, int target) {
        int[] res = new int[2];

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (target - num[i] == num[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return res;
    }

    private int[] twoSum2(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int desired = target - num[i];
            if (map.containsKey(desired)) {
                return new int[] {map.get(desired), i};
            } else {
                map.put(num[i], i);
            }
        }
        return new int[2];
    }

}
