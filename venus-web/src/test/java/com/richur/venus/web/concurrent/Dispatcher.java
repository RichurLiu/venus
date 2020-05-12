package com.richur.venus.web.concurrent;

import com.richur.venus.biz.util.ThreadFactoryUtils;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author richur
 * @since v0.0.1
 */
public class Dispatcher {
    Client client;
    private Future<Object> resultFuture;
    private String sql;
    private String jobId;

    public Dispatcher() {

    }

    public Dispatcher(Client client,String sql) {
        this.client = client;
        this.sql = sql;
    }

    private void executeAsync() {
        ExecutorService executorService = ThreadFactoryUtils.getSingleThreadScheduleExecutor("auto-dispatcher-protocol-thread-"
                + Clock.systemDefaultZone().millis());

//        resultFuture = executorService.submit(() -> {
//            client.submitJob(sql);
//            jobId = client.getJobId();
//            while (true){
//                if(client.isSuccess()){
//                    return client.getResult(jobId);
//                } else {
//                    return null;
//                }
//            }
//
//        });
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

    private String getVersion(){
        return client.getVersion();
    }

    private void close(){
        if (resultFuture != null && !resultFuture.isDone() && !resultFuture.isCancelled()) {
            try {
                boolean b = resultFuture.cancel(true);

            } catch (Exception e) {
            }
        }
        try {
            if (jobId != null && client != null) {
            }
            if (client != null) {
                client = null;
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Map<Integer,Dispatcher> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setVersion("version:" + i);
            client.setDescription("description:" + i);
            String sql = "select * from ss limit" + i;
            Dispatcher dispatcher = new Dispatcher(client,sql);
            dispatcher.executeAsync();
            map.put(i,dispatcher);
            System.out.println(sql);
            //dispatcher.getResult();
        }


        int count =0;
        while(true){
            try {
                Thread.sleep(400);
                count ++;
                if(count > 25){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("==============================");
            for (int i = 0; i < 10; i++) {
                Dispatcher dispatcher = map.get(i);
                String result = dispatcher.getResult();
                System.out.println(i+":"+result);
                System.out.println(i+":"+dispatcher.getVersion());
                System.out.println("------------------------------------");
            }

        }
        for (int i = 0; i < 10; i++) {
            Dispatcher dispatcher = map.get(i);
            dispatcher.close();
        }
        System.out.println("over");
    }

}
