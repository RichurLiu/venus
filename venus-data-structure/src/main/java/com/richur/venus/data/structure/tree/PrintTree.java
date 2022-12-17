package com.richur.venus.data.structure.tree;

import java.util.*;

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
        System.out.print(node.getVal() + " ");
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
        System.out.print(node.getVal() + " ");
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
        System.out.print(node.getVal() + " ");
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
            System.out.print(n.getVal() + " ");
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
            System.out.print(cur.getVal() + " ");
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
            System.out.print(s2.pop().getVal() + " ");
        }
    }

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node n = q.poll();
                System.out.print(n.val + " ");
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                size --;
            }
            System.out.println();
        }
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
     * 创建二叉树
     * 1
     * /   \
     * 2   3
     * /
     * 4
     * / \
     * 5  6
     */
    public static Node buildTree2() {
        Node node = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        node.setLeft(left1);
        node.setRight(right1);
        Node right2 = new Node(4);
        right1.left = right2;
//        left1.setRight(right2);
        Node left3 = new Node(5);
        Node right3 = new Node(6);
        right2.setLeft(left3);
        right2.setRight(right3);
        return node;
    }

    /**
     * 创建二叉搜索树
     * 6
     * /   \
     * 2   8
     * \
     * 4
     * / \
     * 3  5
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


    public static Node createTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        int index = 0;
        int length = array.length;
        Node root = new Node(array[0]);
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Node currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new Node(leftChild);
                nodeQueue.add(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new Node(rightChild);
                nodeQueue.add(currNode.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
//        preOrder(buildTree());
//        System.out.println();
//        midOrder(buildTree());
//        System.out.println();
//        levelOrder(buildTree());
//        System.out.println();
//        levelOrder(buildTree2());
//        System.out.println();
//        Node1 node = mergeTrees(buildTree(), buildTree2());
//
//        levelOrder(node);

//        postOrder(buildTree());
//        System.out.println();

//        fPreOrder(buildTree());
//        fMidOrder(buildTree());
//        fMidOrderV2(buildTree());
//        fPostOrder(buildTree());
//        System.out.println();
//        levelOrder(buildTree());

        Integer[] arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Node node = createTree(arr);
        levelOrder(node);
    }


    public static boolean findTarget(Node root, int target) {
        if (root == null && target == 0) {
            return true;
        }
        int value = root.val;
        findTarget(root.left, target - value);
        findTarget(root.right, target - value);
        return false;
    }

    /**
     * 剑指Offer 34
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(Node root, int sum) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        recur(root, sum, res, path);
        return res;
    }

    public void recur(Node root, int tar, LinkedList<List<Integer>> res, LinkedList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar, res, path);
        recur(root.right, tar, res, path);
        path.removeLast();
    }

}
