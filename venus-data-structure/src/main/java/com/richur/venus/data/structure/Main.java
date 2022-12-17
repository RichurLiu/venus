package com.richur.venus.data.structure;

/**
 * @author richur
 */
public class Main {
    public synchronized void test01() {
        int a = 0;
    }

    public void test02() {
        synchronized(this) {
            int a = 0;
        }
    }
}
