package com.richur.venus.biz.util.thread.pool;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {

        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;

        System.out.println("COUNT_BITS:" + COUNT_BITS);
        System.out.println("CAPACITY:" + CAPACITY);
        System.out.println("RUNNING:" + RUNNING);
        System.out.println("SHUTDOWN:" + SHUTDOWN);
        System.out.println("STOP:" + STOP);
        System.out.println("TIDYING:" + TIDYING);
        System.out.println("TERMINATED:" + TERMINATED);
    }
}
