package com.richur.venus.biz.util.thread;

import java.util.concurrent.*;

/**
 * @author richur
 */
public class ThreadPoolTest {

//    private ExecutorService pool = Executors.newFixedThreadPool(5);

    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 16, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));


    public static void main(String[] args) throws InterruptedException {

        ThreadPoolTest test = new ThreadPoolTest();

        System.out.println("start 1 ...");
        test.getInfo();
        System.out.println("start 2 ...");
        for (int i = 0; i < 10; i++) {
            test.execute(i);
        }
        System.out.println("end 1 ...");
        System.out.println("start 2 ...");
        test.getInfo();
        System.out.println("start 2 ...");
        for (int i = 0; i < 10; i++) {
            test.execute(i + 10);
        }
        System.out.println("end 2 ...");

        while (test.get() < 20){
            Thread.sleep(500);
            test.getInfo();
        }
    }


    private void execute(final int i){
//        Future<Integer> executeFuture = null;

        executor.execute(()->{
            //System.out.println("123");
            try {
                Thread.sleep(1000 * i);
                System.out.println("线程"+ i +"end!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            return i;
        });

        //System.out.println("==1==线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
        getInfo();
//        try {
//            Integer integer = executeFuture.get();
//            System.out.println("完成:"+ integer);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }


    private void getInfo(){
        System.out.println("==1==线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
    }


    long get(){
        return executor.getCompletedTaskCount();
    }
}
