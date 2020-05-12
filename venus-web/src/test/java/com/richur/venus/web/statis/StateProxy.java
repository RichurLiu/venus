package com.richur.venus.web.statis;

/**
 * @author richur
 * @since v0.0.1
 */
public class StateProxy {
    private static final StateProxy INSTANCE = new StateProxy();
    private static final RaftServer raftServer = RaftServer.getInstance();
    public static StateProxy getInstance() {
        System.out.println("StateProxy getInstance");
        return INSTANCE;
    }

    private void doTask(){
        String info = raftServer.getInfo();
        System.out.println(StateProxy.class + "info");
    }


    public static void main(String[] args) {
        StateProxy.getInstance().doTask();
    }
}
