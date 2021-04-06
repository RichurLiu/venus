package com.richur.venus.data.structure.linkedlist;

/**
 * @author richur
 */
public class LNode<T> {
    public T data;
    public LNode next;

    public LNode() {
    }

    public LNode(T data) {
        this.data = data;
    }

    public LNode(T data, LNode next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }
}
