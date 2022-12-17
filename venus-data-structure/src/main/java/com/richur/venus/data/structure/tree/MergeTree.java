package com.richur.venus.data.structure.tree;

import javax.swing.tree.TreeNode;
import java.util.*;


public class MergeTree {

    public static void main(String[] args) {
        // 打印A树
//        System.out.println("TreeA:");
//        printList(levelOrder(buildTreeA()));
//        // 打印B树
//        System.out.println("TreeB:");
//        printList(levelOrder(buildTreeB()));
//        // 合并A，B树
//        Node node = mergeTrees(buildTreeA(), buildTreeB());
//        // 打印合并后的树
//        System.out.println("mergeTree:");
//        printList(levelOrder(node));

        int n = 17;
        n = n >> 1;

        System.out.println(2 + 2>> 1);

        System.out.println("DACCC".substring(1));
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);

    }

    public static Node mergeTrees(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node merged = new Node(node1.val + node1.val);
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> queue1 = new ArrayDeque<>();
        Queue<Node> queue2 = new ArrayDeque<>();
        queue.add(merged);
        queue1.add(node1);
        queue2.add(node2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Node node = queue.poll();
            Node n1 = queue1.poll();
            Node n2 = queue2.poll();
            Node left1 = n1.left;
            Node left2 = n2.left;
            Node right1 = n1.right;
            Node right2 = n2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    Node left = new Node(left1.val + left2.val);
                    node.left = left;
                    queue.add(left);
                    queue1.add(left1);
                    queue2.add(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    Node right = new Node(right1.val + right2.val);
                    node.right = right;
                    queue.add(right);
                    queue1.add(right1);
                    queue2.add(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }

    /**
     * 创建二叉树
     * 1
     * /   \
     * 2   3
     * \
     * 4
     * / \
     * 5  6
     */
    public static Node buildTreeA() {
        Node node = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        node.left = left1;
        node.right = right1;
        Node right2 = new Node(4);
        left1.right = right2;
        Node left3 = new Node(5);
        Node right3 = new Node(6);
        right2.left = left3;
        right2.right = right3;
        return node;
    }

    /**
     * 创建二叉树
     * 1
     * /   \
     * 2   3
     * /
     * 4
     * / \
     * 5  6
     */
    public static Node buildTreeB() {
        Node node = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        node.left = left1;
        node.right = right1;
        Node right2 = new Node(4);
        right1.left = right2;
        Node left3 = new Node(5);
        Node right3 = new Node(6);
        right2.left = left3;
        right2.right = right3;
        return node;
    }

    public static List<Node> levelOrder(Node node) {
        List<Node> list = new ArrayList<>();
        Queue<Node> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            list.add(n);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return list;
    }

    public static void printList(List<Node> list) {
        for (Node node : list) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }


    public static Node mergeTrees2(Node root1, Node root2) {
        return mergeDFS(root1, root2);
    }

    /**
     * 深度优先搜索
     *
     * @param root1
     * @param root2
     * @return
     */
    private static Node mergeDFS(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        Node result = new Node();
        int value = 0;
        if (root1 != null) {
            value = value + root1.val;
        }

        if (root2 != null) {
            value = value + root2.val;
        }
        result.val = value;

        result.left = mergeDFS(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        result.right = mergeDFS(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return result;
    }
}
