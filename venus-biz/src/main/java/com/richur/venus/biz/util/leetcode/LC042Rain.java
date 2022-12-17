package com.richur.venus.biz.util.leetcode;

public class LC042Rain {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,3};
        System.out.println(trap(arr));
    }

    public static int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int j = 1;
        int total = 0;
        for(int i=0;i < height.length - 1 && j < height.length; ){
            int cur = 0;
            if(height[j] >= height[i]) {
                i = j;
                j++;
            } else {
                while(j < height.length && height[j] < height[i]) {
                    cur = cur + height[i] - height[j];
                    j++;
                    if(j >= height.length){
                        i++;
                        j=i+1;
                        cur = 0;
                    }
                }
            }
            System.out.println("cur:"+cur+",i:"+i+",j:"+j);
            total = total + cur;
        }
        return total;
    }
}
