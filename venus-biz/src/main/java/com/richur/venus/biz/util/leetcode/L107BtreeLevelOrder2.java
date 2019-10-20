package com.richur.venus.biz.util.leetcode;

import com.richur.venus.biz.util.leetcode.model.BTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author richur
 * @Date 2019/10/20 4:25 PM
 */
public class L107BtreeLevelOrder2 {

    public static void main(String[] args) {
        BTreeNode root = buildTree();
        System.out.println(levelOrderBottom(root));
    }

    public static List<List<Integer>> levelOrderBottom(BTreeNode root) {
        List<List<Integer>> dataList = new ArrayList<>();
        List<List<BTreeNode>> nodeList = new ArrayList<>();

        List<BTreeNode> curListNode = new ArrayList<>(Collections.singletonList(root));
        nodeList.add(curListNode);
        int deep = 0;
        while(curListNode.size() != 0){
            List<BTreeNode> temp = new ArrayList<>();
            for(BTreeNode node : curListNode){
                if(node.getLeft() != null){
                    temp.add(node.getLeft());
                }
                if(node.getRight() != null){
                    temp.add(node.getRight());
                }
            }
            nodeList.add(temp);
            deep ++;
            curListNode = nodeList.get(deep);
        }

        for(int i = nodeList.size()-2; i >= 0; i --){
            List<Integer> list = new ArrayList<>();
            for(BTreeNode node : nodeList.get(i)){
                list.add(node.getData());
            }
            dataList.add(list);
        }
        return dataList;
    }

    /**
     * 创建二叉树
     *    1
     *  /   \
     *  2   3
     *  \
     *  4
     * / \
     *5  6
     */
    private static BTreeNode buildTree() {
        BTreeNode node = new BTreeNode(1);
        BTreeNode left1 = new BTreeNode(2);
        BTreeNode right1 = new BTreeNode(3);
        node.setLeft(left1);
        node.setRight(right1);
        BTreeNode right2 = new BTreeNode(4);
        left1.setRight(right2);
        BTreeNode left3 = new BTreeNode(5);
        BTreeNode right3 = new BTreeNode(6);
        right2.setLeft(left3);
        right2.setRight(right3);
        return node;
    }
}
