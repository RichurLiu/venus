package com.richur.venus.web.statis;

/**
 * @author richur
 * @since 0.0.1
 */
public class RaftServer {

    private RaftServer(){
        init();
    }

    private void init(){
        System.out.println("init");
    }

    private static class InstanceHolder{
        static final RaftServer INSTANCE = new RaftServer();
    }

    public static RaftServer getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public String getInfo(){
        System.out.println("getInfo");
        return "getInfo";
    }
}
