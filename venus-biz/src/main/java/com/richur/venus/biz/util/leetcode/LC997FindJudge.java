package com.richur.venus.biz.util.leetcode;

/**
 * @Author Richur
 * @Date 2019/12/24 9:13 下午
 */
public class LC997FindJudge {

    public static void main(String[] args) {

    }

    public int findJudge(int N, int[][] trust) {

        int [][] flag = new int[N+1][2];

        for (int i = 1; i < trust.length; i++) {
            flag[trust[i][0]][0] = flag[trust[i][0]][0] + 1;
            flag[trust[i][1]][1] = flag[trust[i][1]][1] + 1;
        }

        for (int i = 1; i <= N; i++) {
            if(flag[i][0] == 0 && flag[i][1] == N){
                return i;
            }
        }
        return -1;
    }
}
