package com.richur.venus.leetcode;

import java.util.*;

public class A442DuplicateKey {

    public static void main(String[] args) {
        int[] num = new int[]{4,3,2,7,8,2,3,1,10,10,10};
        duplicate(num);
    }

    public static List<Integer> duplicate(int[] nums) {
        List<Integer> duplicateList = new ArrayList<>();
        if (null == nums || nums.length <= 0) {
            return duplicateList;
        }
//        int l = nums.length;
//       for (int i:nums){
//            int j = (i-1) % l;
//            nums[j] += l;
//        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = (nums[i]-1) % len;
            nums[j] = nums[j] + len;
            System.out.println("num["+((nums[i] - 1) % len)+"]="+ nums[(nums[i] - 1) % len]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * len) {
                if (!duplicateList.contains(i+1)) {
                    duplicateList.add(i+1);
                }
            }
        }
        System.out.println(duplicateList);
        return duplicateList;
    }

    public static void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
