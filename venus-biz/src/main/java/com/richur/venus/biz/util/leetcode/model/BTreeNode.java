package com.richur.venus.biz.util.leetcode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author richur
 * @Date 2019/10/20 4:18 PM
 */
@Setter
@Getter
@NoArgsConstructor
public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;
    public BTreeNode(int data){
        this.data = data;
    }
}
