package com.richur.venus.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class A22GenerateParenthesis {
    public static void main(String[] args) {
        A22GenerateParenthesis a = new A22GenerateParenthesis();
        List<String> strings = a.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String str, int left, int right, List<String> res){
        if(left== 0 && right == 0){
            res.add(str);
            return;
        }
        if(left > right){
            return;
        }
        if(left>0){
            dfs(str+"(", left-1, right, res);
        }
        if(right>0){
            dfs(str+")", left, right-1, res);
        }
    }
}
