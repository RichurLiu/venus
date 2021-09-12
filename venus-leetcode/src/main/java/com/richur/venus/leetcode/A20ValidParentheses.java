package com.richur.venus.leetcode;

public class A20ValidParentheses {
    public static void main(String[] args) {
        A20ValidParentheses v = new A20ValidParentheses();
        boolean valid = v.isValid("(())");
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if(len % 2 != 0){
            return false;
        }
        int leftCharLen = len / 2;
        char[] leftChar = new char[leftCharLen];
        int j = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                    if (j == leftCharLen) {
                        return false;
                    }
                    leftChar[j] = '(';
                    j++;
                    break;
                case ')':
                    if ( j == 0 || leftChar[j - 1] != '(') {
                        return false;
                    } else {
                        j--;
                    }
                    break;
                case '[':
                    if (j == leftCharLen) {
                        return false;
                    }
                    leftChar[j] = '[';
                    j++;
                    break;
                case ']':
                    if (j == 0 || leftChar[j - 1] != '[') {
                        return false;
                    } else {
                        j--;
                    }
                    break;
                case '{':
                    if (j == leftCharLen) {
                        return false;
                    }
                    leftChar[j] = '{';
                    j++;
                    break;
                case '}':
                    if (j == 0 || leftChar[j - 1] != '{') {
                        return false;
                    } else {
                        j--;
                    }
            }
        }
        return j == 0;
    }
}
