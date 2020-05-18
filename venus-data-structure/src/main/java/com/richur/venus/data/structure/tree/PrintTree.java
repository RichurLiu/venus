package com.richur.venus.data.structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author richur
 */
public class PrintTree {
    /**
     * 递归前序遍历
     *
     * @param node
     */
    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    private static void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        midOrder(node.getRight());
    }

    /**
     * 递归后序遍历
     *
     * @param node
     */
    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }

    /**
     * 非递归前序遍历
     *
     * @return
     */
    private static void fPreOrder(Node node) {
        Stack<Node> s = new Stack();
        s.push(node);
        while (!s.empty()) {
            Node n = s.pop();
            System.out.print(n.getData() + " ");
            if (n.getRight() != null) {
                s.push(n.getRight());
            }
            if (n.getLeft() != null) {
                s.push(n.getLeft());
            }
        }
    }


    /**
     * 非递归中序遍历
     *
     * @return
     */
    private static void fMidOrder(Node node) {
        Stack<Node> s = new Stack();
        Node cur = node;
        while (!s.empty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.getLeft();
            }
            cur = s.pop();
            System.out.print(cur.getData() + " ");
            cur = cur.getRight();
        }
    }

    /**
     * 非递归后序遍历
     *
     * @return
     */
    private static void fPostOrder(Node node) {
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(node);
        while (!s1.empty()) {
            Node n = s1.pop();
            if (n.getLeft() != null) {
                s1.push(n.getLeft());
            }
            if (n.getRight() != null) {
                s1.push(n.getRight());
            }
            s2.push(n);
        }
        while (!s2.empty()) {
            System.out.print(s2.pop().getData() + " ");
        }
    }

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.getData() + " ");
            if (n.getLeft() != null) {
                q.add(n.getLeft());
            }
            if (n.getRight() != null) {
                q.add(n.getRight());
            }
        }
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
    public static Node buildTree() {
        Node node = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        node.setLeft(left1);
        node.setRight(right1);
        Node right2 = new Node(4);
        left1.setRight(right2);
        Node left3 = new Node(5);
        Node right3 = new Node(6);
        right2.setLeft(left3);
        right2.setRight(right3);
        return node;
    }

    /**
     * 创建二叉搜索树
     *    6
     *  /   \
     *  2   8
     *  \
     *  4
     * / \
     *3  5
     */
    public static Node buildSearchTree() {
        Node node = new Node(6);
        Node left1 = new Node(2);
        Node right1 = new Node(8);
        node.setLeft(left1);
        node.setRight(right1);
        Node right2 = new Node(4);
        left1.setRight(right2);
        Node left3 = new Node(3);
        Node right3 = new Node(5);
        right2.setLeft(left3);
        right2.setRight(right3);
        return node;
    }


    public static void main(String[] args) {
//        preOrder(buildTree());
//        System.out.println();
//        midOrder(buildTree());
        System.out.println();
        postOrder(buildTree());
        System.out.println();

//        fPreOrder(buildTree());
//        fMidOrder(buildTree());
//        fMidOrderV2(buildTree());
//        fPostOrder(buildTree());
        System.out.println();
        levelOrder(buildTree());
    }
}
