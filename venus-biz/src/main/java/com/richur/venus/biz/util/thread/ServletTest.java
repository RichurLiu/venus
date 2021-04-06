package com.richur.venus.biz.util.thread;

import java.util.Date;

/**
 * @author richur
 */
public class ServletTest {
    private static String user;
    private static String pass;

    public static void doPost(String userRef, String passRef) {
        try {
            user = userRef;
            if ("a".equals(user)) {
                Thread.sleep(2000);
            }
            pass = passRef;
            System.out.println("user:" + user + ", pass:" + pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
