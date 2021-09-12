package com.richur.venus.offer;

public class StringStreamFirst {

    public static void main(String[] args) {
        String firstChar = getFirstChar("go");
        System.out.println(firstChar);
    }


    public static String getFirstChar(String str){
        if(null == str || str.length() == 0) {
            return "";
        }
        char[] ch = new char[255];
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            ch[chars[i]] ++ ;
        }

        for (int i = 0; i < str.length(); i++) {
            if(ch[chars[i]] == 1){
                return String.valueOf(chars[i]);
            }
        }
        return "";
    }
}
