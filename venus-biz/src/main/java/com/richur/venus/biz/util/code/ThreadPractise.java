package com.richur.venus.biz.util.code;

import java.util.Map;

/**
 * @Author richur
 * @Date 2019/8/29 9:47 AM
 */
public class ThreadPractise {

    private int count = 0;
    private final Object lock = new Object();

    class TurningRunner implements Runnable{
        @Override
        public void run() {
            while(count <= 100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notifyAll();
                    try{
                        if(count <= 100){
                            lock.wait();
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void turning(){
        new Thread(new TurningRunner(), "偶数").start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new TurningRunner(), "奇数").start();
    }

    public static void main(String[] args) {
        ThreadPractise tp = new ThreadPractise();
        tp.turning();
    }
}


