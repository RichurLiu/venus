package com.richur.venus.data.structure.tree;

/**
 * @author richur
 */
public class BinarySearchTree {
    private Node tree;

    private Node find(int data) {
        Node p = tree;
        while (null != p) {
            if (p.val == data) {
                return p;
            } else if (p.val > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }


    private void insert(int data) throws Exception {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (null != p) {
            if (p.val == data) {
                throw new Exception("node has exist.");
            }
            if (p.val > data) {
                if (null == p.left) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if (null == p.right) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 1.删除的节点没有子节点，只需要直接删除即可（将其父节点指向要删节点的指针置为空）
     * 2.删除的节点只有一个子节点，只需要更新父节点，将其指向删除节点的指针指向要删除节点的子节点
     * 3.删除节点有两个子节点，找到这个删除节点的右子树中的最小节点，把他替换到删除的节点上，然后删除这个最小节点
     */
    private void delete(int data) {
        //p 指向要删除的节点，初始化指向根节点
        Node p = tree;
        //pp 记录被删节点的父节点
        Node pp = null;
        while(p != null && p.val !=data){
            pp = p;
            if (p.val > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //没找到删除的节点
        if(p == null){
            System.out.println("没找到删除的节点:"+ data);
            return;
        }

        if (p.left != null && p.right != null) {//左右子树都不为null
            Node minP = p.right;//被删节点的子树中的最小节点
            Node minPp = p; //minP 的父节点
            while(minP.left != null){
                minPp = minP;
                minP = minPp.left;

            }
            p.val = minP.val;//值替换
            p = minP; //下面开始删除minP节点
            pp = minPp;
        }
        Node child;

        if(p.left != null){
            child = p.left;
        } else if(p.right != null){
            child = p.right;
        } else {
            child = null;
        }
        if(pp == null){
            tree = child;
        } else if(pp.left == p){
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 测试 查询
     */
    private static void find() {
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.tree = PrintTree.buildSearchTree();

        Node targetNode = bsTree.find(4);

        if (targetNode != null) {
            System.out.println(targetNode.val);
        } else {
            System.out.println("NULL");
        }
    }

    /**
     * 测试 插入
     */
    private static void insert() {
        BinarySearchTree bsTree = new BinarySearchTree();
        try {
            bsTree.insert(6);
            bsTree.insert(2);
            bsTree.insert(8);
            bsTree.insert(4);
            bsTree.insert(3);
            bsTree.insert(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintTree.levelOrder(bsTree.tree);
    }

    /**
     * 测试 删除
     */
    private static void delete() {
        BinarySearchTree bsTree = new BinarySearchTree();
        try {
            bsTree.insert(8);
            bsTree.insert(7);
            bsTree.insert(15);
            bsTree.insert(3);
            bsTree.insert(5);
            bsTree.insert(1);
            bsTree.insert(2);
            bsTree.insert(4);
            bsTree.insert(6);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        PrintTree.levelOrder(bsTree.tree);
        System.out.println();
//        bsTree.delete(3);
//        PrintTree.levelOrder(bsTree.tree);
//        System.out.println();
//        bsTree.delete(8);
//        PrintTree.levelOrder(bsTree.tree);
//        System.out.println();
        bsTree.delete(3);
        PrintTree.levelOrder(bsTree.tree);
        System.out.println();
//        bsTree.delete(1);
//        PrintTree.levelOrder(bsTree.tree);


    }

    public static void main(String[] args) {
//        find();
//        insert();
        delete();


    }
}
