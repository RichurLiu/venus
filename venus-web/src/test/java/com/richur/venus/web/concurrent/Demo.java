package com.richur.venus.web.concurrent;

import com.richur.venus.biz.util.ThreadFactoryUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author richur
 * @since v0.0.1
 */
@Slf4j
public class Demo {

    private Future<Object> resultFuture;
//    private Object res;
    private Client client;
    private String sql;
    private String jobId;

    public Demo(Client client, String sql) {
        this.client = client;
        this.sql = sql;
    }

    private void executeAsync(int t) {
        ExecutorService executorService = ThreadFactoryUtils.getSingleThreadScheduleExecutor("auto-dispatcher-protocol-thread-"
                + Clock.systemDefaultZone().millis());
//
//        Thread t = new Thread(()->{
//            System.out.println("execute");
//        });
//        t.setName("kkkkk");
//        t.start();

        resultFuture = executorService.submit(() -> {
            client.submitJob(sql);
            jobId = client.getJobId();
            while (true){
//                System.out.println("ready ll...");
                log.info("ready ll ...");
                if(client.isSuccess()){
//                    System.out.println("ready ...");
                    log.info("ready ...");
                    return client.getResult(jobId);
                } else {
//                    System.out.println("not ready ...");
                    log.info("not ready ...");
                    Thread.sleep(2000);
                }
            }
        });
//        if(t<4)
        executorService.shutdown();
//        Callable callable = () -> {
//            System.out.println("callable:" + sql);
//            client.submitJob(sql);
//            jobId = client.getJobId();
//            while (true){
//                if(client.isSuccess()){
//                    System.out.println("done ... ");
//                    return client.getResult(jobId);
//                } else {
//                    System.out.println("running ... ");
//                    Thread.sleep(100);
//                }
//            }
//        };
//        try {
//            res = callable.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //executorService.shutdown();
    }

    private String getResult(){

        if(null == resultFuture){
            System.out.println("resultFuture null");
            return null;
        }
        if(!resultFuture.isDone()){
            System.out.println("resultFuture not isDone");
            return null;
        }
        try {
            Object object = resultFuture.get();
            return object.toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }



    public static void main(String[] args) throws InterruptedException {
        Map<Integer,Demo> map = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            Client client = new Client();
            Demo demo = new Demo(client, "select * from a limit" + i);
            demo.executeAsync(i);
            map.put(i, demo);
            System.out.println("execut sql" + i);
        }
//        Thread.sleep(1000);

        int count =0;
//        while(true) {
//            for (int i = 1; i < 5; i++) {
//                Demo demo = map.get(i);
////            Object call = demo.s;
////                System.out.println(demo.getResult());
//
//            }
//            Thread.sleep(1000);
//            if(count > 10){
//                break;
//            }
//            count++;
//        }

    }
}
