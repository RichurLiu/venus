package com.richur.venus.biz.util.thread;

import java.util.Date;

/**
 * @author richur
 */
public class ThreadDemo extends Thread {
    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("1-thread name is:" + name + new Date());
        ServletTest.doPost(name, name);
        System.out.println("2-thread name is:" + name + new Date());
//        System.out.println("2-thread name is:" + name);
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("a");
        ThreadDemo t2 = new ThreadDemo("b");
        ThreadDemo t3 = new ThreadDemo("c");
        t1.start();
        t2.start();
//        t3.start();
    }
}
