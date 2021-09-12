package com.richur.venus.leetcode;

public class A5824MaxNum {
    public static void main(String[] args) {
        A5824MaxNum a = new A5824MaxNum();
        int[]change = new int[]{9,4,3,5,7,2,1,9,0,6};
        //System.out.println(a.maximumNumber("021", change));

        int[][] students = new int[][]{{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors  = new int[][]{{1,0,0},{0,0,1},{1,1,1}};
        int s = a.maxCompatibilitySum(students, mentors);
        System.out.println(s);
    }

    public String maximumNumber(String num, int[] change) {
        boolean flag = false;
        String newNum = "";
        int index = 0;
        for (int i = 0; i < num.length(); i++) {
            int ch = num.charAt(i) - 48;
            if(ch < change[ch]) {
                flag = true;
                newNum += change[ch]+"";
            } else {
                if(flag && ch != change[ch]){
                    index = i;
                    break;
                }
                newNum += ch+"";
            }
        }
        if(index == 0){
            index =  num.length();
        }
        newNum += num.substring(index);
        return newNum;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int len = students.length;
        int [] s = new int[len];
        for (int i = 0; i < len; i++) {
            int sans0 = 0;
            int mans0 = 0;
            for (int j = 0; j < len; j++) {
                if(students[j][i] == 0){
                    sans0 ++;
                }
                if(mentors[j][i] == 0){
                    mans0 ++;
                }
            }
            if(sans0 < mans0){
                s[i] = sans0 + len - mans0;
            } else {
                s[i] = mans0 + len - sans0;
            }
        }
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += s[i];
        }
        return total;
    }

}
