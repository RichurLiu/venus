package com.richur.venus.biz.util.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author richur
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> implCallable = new CallableImpl();
        FutureTask<Integer> futureTask = new FutureTask<>(implCallable);
        new Thread(futureTask).start();
        long start = System.currentTimeMillis();
        System.out.println("start...."+ start);
        System.out.println("result:"+futureTask.get());
        long end = System.currentTimeMillis();
        System.out.println("end......"+ end +",cost:"+ (end - start) +"ms");
    }
}

class CallableImpl implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for(int i=0;i<10;i++){
            result += i;
        }
        Thread.sleep(2000);
        return result;
    }
}
