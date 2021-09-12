package com.richur.venus.leetcode;

import java.util.*;

public class A15ThreeSum {
    public static void main(String[] args) {
        A15ThreeSum a = new A15ThreeSum();
        int[] arr = new int[]{0,0,0,0};
        System.out.println(a.threeSum02(arr));


    }

    //todo bug
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for(int i=0;i<nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                int tmp = - (nums[i] + nums[j]);
                if(set.contains(tmp)){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(tmp);
                    //set.remove(tmp);
                    list.add(res);
                }
            }
            System.out.println("=========="+ list);

        }
        return list;
    }


    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}
