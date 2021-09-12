package com.richur.venus.leetcode;

import java.util.*;

public class A18FourSum {
    public static void main(String[] args) {
        A18FourSum a = new A18FourSum();
        int[] arr = new int[]{0,0,0,0};
        System.out.println(a.fourSum(arr));


    }
    public List<List<Integer>> fourSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

}
