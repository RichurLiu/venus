package com.richur.venus.data.structure.linkedlist;

/**
 * @author richur
 * 1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 * 如果此时缓存未满，则将此结点直接插入到链表的头部；
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
 */
@SuppressWarnings("unchecked")
public class LRU<T> {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;
    private LNode<T> headNode;
    /**
     * 链表长度
     */
    private int length;
    /**
     * 链表容量
     */
    private int capacity;

    public LRU() {
        this.headNode = new LNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRU(int capacity) {
        this.headNode = new LNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        LNode preNode = findPreNode(data);
        if(null != preNode.next){
            //找到
            deleteData(preNode);
            insertAtBegin(data);
        } else {
            if(length >= this.capacity){
                //todo 删除最后一个节点
            }
            insertAtBegin(data);
        }
    }

    public LNode findPreNode(T data) {
        LNode node = headNode;
        while (null != node.next) {
            if (data.equals(node.next.data)) {
                return node;
            }
        }
        //最后一个节点
        return node;
    }

    /**
     * 删除preNode的下一节点
     * @param preNode
     */
    private void deleteData(LNode preNode){
        LNode tmp = preNode.next;
        preNode.next = tmp.next;
        tmp = null;
        length --;
    }

    /**
     * 头部插入节点
     * @param data
     */
    private void insertAtBegin(T data){
        LNode newNode = new LNode(data);
        newNode.next = headNode.next;
        headNode.next = newNode;
        length ++;
    }


    public static void main(String[] args) {

    }
}
