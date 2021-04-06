package com.richur.venus.biz.util.thread;

/**
 * @author richur
 */
public class RunnableDemo {
    public static void main(String[] args) {
        RunnableImpl r1 = new RunnableImpl("first runnable");
        RunnableImpl r2 = new RunnableImpl("second runnable");
        RunnableImpl r3 = new RunnableImpl("third runnable");

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();

        new Thread(() -> {
            String name = "first runnable";
            System.out.println("runnable name is:" + name);
        }).start();
    }
}

class RunnableImpl implements Runnable {
    public String name;

    public RunnableImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("runnable name is:" + name);
    }
}
