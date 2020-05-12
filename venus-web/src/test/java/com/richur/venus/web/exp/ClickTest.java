package com.richur.venus.web.exp;

import sun.jvm.hotspot.memory.TenuredSpace;

/**
 * @author richur
 * @since v0.0.1
 * 1.静态方法，静态代码块会按先后声明顺序执行
 * 2.静态代码块只会执行一次
 * 3.在实例化对象的时候代码块都会执行
 */
public class ClickTest {
    {
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
    public static ClickTest t1 = new ClickTest();

    public static void main(String[] args) {
        ClickTest t = new ClickTest();
    }
}

