package com.richur.venus.data.structure.linkedlist;

/**
 * @author richur
 * 插入
 * 查询
 * 删除
 */
public class LinkedListBase<T> {
    /**
     * 头节点
     */
    private LNode<T> headNode;
    /**
     * 尾节点
     */
    private LNode<T> tailNode;
    /**
     * 链表长度
     */
    private int length;

    public LinkedListBase(){
        this.headNode = new LNode<>();
        this.tailNode = new LNode<>();
        this.length = 0;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    public void insertHead(T data) {
        LNode next = headNode.getNext();
        headNode.setNext(new LNode<>(data, next));
        length++;
    }

    private void insertHeadBase(T data) {
        LNode newNode = new LNode<>(data);
        LNode next = headNode.next;
        headNode.next = newNode;
        newNode.next = next;
        length++;
    }

    /**
     * 链表尾部插入节点
     *
     * @param data
     */
    private void insertTail(T data) {
        if(headNode.next == null){
            headNode = tailNode;
        }
        LNode node = tailNode;
        tailNode = new LNode<>(data);
        node.next = tailNode;

        length++;
    }

    public void printAll() {
        LNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getData() + ",");
            node = node.getNext();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedListBase<Integer> link = new LinkedListBase<>();
        link.insertTail(1);
        link.insertTail(2);
        link.printAll();
        link.insertTail(3);
        link.insertTail(4);
        link.insertTail(6);
        link.insertTail(5);
        link.printAll();
    }
}
