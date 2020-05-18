package com.richur.venus.data.structure.tree;

/**
 * @author richur
 */
public class BinarySearchTree {
    private Node tree;

    private Node find(int data) {
        Node p = tree;
        while (null != p){
            if(p.data == data){
                return p;
            } else if(p.data > data){
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }


    private void insert(int data) throws Exception{
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (null != p){
            if(p.data == data){
                throw new Exception("node has exist.");
            }
            if(p.data > data){
                if(null == p.left){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else {
                if(null == p.right){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 测试 查询
     */
    private static void find(){
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.tree = PrintTree.buildSearchTree();

        Node targetNode = bsTree.find(4);

        if (targetNode != null) {
            System.out.println(targetNode.data);
        } else {
            System.out.println("NULL");
        }
    }

    /**
     * 测试 插入
     */
    private static void insert(){
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
    public static void main(String[] args) {
//        find();
        insert();

    }
}
