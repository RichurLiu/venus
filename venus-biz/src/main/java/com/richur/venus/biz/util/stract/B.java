package com.richur.venus.biz.util.stract;

import sun.net.util.IPAddressUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author richur
 */
public class B extends A{
    B(Runnable runnable) {
       // super(runnable);
    }

//    @Override
//    public void start(){
//        //super.start();
//        System.out.println("B");
//
//    }

    public static void main(String[] args) {
//        A a = new B(()->{
//            System.out.println("asd");
//        });
        boolean test = test(10294);
        System.out.println(test);

        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    public static boolean test(int value){
        if( value % 3 == 0) {
            return true;
        }
        if(String.valueOf(value).contains("3")) {
            return true;
        }
        return false;
    }
}
