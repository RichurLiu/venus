package com.richur.venus.leetcode;

public class A5823CharToNumber {
    public static void main(String[] args) {
        A5823CharToNumber a = new A5823CharToNumber();
        System.out.println(a.getLucky("zbax", 2));
    }

    public int getLucky(String s, int k) {
        String numberStr = "";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 96;
            numberStr += num+"";
        }
        int res = 0;
        String tmp = numberStr;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (int j = 0; j < tmp.length(); j++) {
                int num =  tmp.charAt(j) - 48;
                res += num;
            }
            tmp = "";
            tmp += res +"";
        }
        return res;
    }
}
