package com.richur.venus.web.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author Richur
 * @Date 2019/12/23 10:51 上午
 */
@Slf4j
public class LeetCode989 {
    public static void main(String[] args) {
        int[] A = {9,9,9};
        int K = 1;
        List<Integer> list = addToArrayForm(A, K);
        System.out.println(list);

    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;

        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            listA.add(A[i]);
        }
        Collections.reverse(listA);
        List<Integer> listK = new ArrayList<>();
        while (K > 0) {
            int num = K % 10;
            listK.add(num);
            K = K / 10;
        }
        List<Integer> list = new ArrayList<>();
        int flag = 0;//进位

        if(listA.size() < listK.size()){
            len = listK.size();
            for (int i = 0; i < len; i++) {
                int res = 0;
                if(listA.size() > i){
                    res = listA.get(i) + listK.get(i) +flag;
                } else {
                    res = listK.get(i) + flag;
                }
                if(res >= 10){
                    flag = 1;
                    list.add(res %10);
                } else {
                    flag = 0;
                    list.add(res);
                }
                if(flag == 1 && i == len -1){
                    list.add(1);
                }
            }
        }


        for (int i = 0; i < len; i++) {
            int res = 0;
            if(listK.size() > i){
                res = listA.get(i) + listK.get(i) +flag;
            } else {
                res = listA.get(i) + flag;
            }
            if(res >= 10){
                flag = 1;
                list.add(res %10);
            } else {
                flag = 0;
                list.add(res);
            }
            if(flag == 1 && i == len -1){
                list.add(1);
            }
        }
        Collections.reverse(list);
        return list;
    }


    public List<Integer> addToArrayFormV2(int[] A, int K) {
        if(A==null||A.length==0)return null;
        LinkedList<Integer> ret=new LinkedList<Integer>();
        int temp=K;
        int i=A.length-1;
        int sum=0;
        while(temp>0||i>=0){
            if(i>=0){
                sum=A[i]+temp%10;
                temp=temp/10;
                if(sum>9){
                    temp++;
                }
                i--;
                ret.addFirst(sum%10);
            }else{
                ret.addFirst(temp%10);
                temp=temp/10;
            }
        }
        return ret;
    }
}
