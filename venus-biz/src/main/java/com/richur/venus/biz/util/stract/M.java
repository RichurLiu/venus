package com.richur.venus.biz.util.stract;


/**
 * @author richur
 */
public class M {
    public static void main(String[] args) {
        int num = 30;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(new PressureRunner());
            threads[i].start();
        }
    }

    public static class PressureRunner implements Runnable {
        @Override
        public void run() {
            int i=0;
            while (true) {
                if(i == 10) {
                    i = 0;
                }
                i++;
            }
        }
    }
}
