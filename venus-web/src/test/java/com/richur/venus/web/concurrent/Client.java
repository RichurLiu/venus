package com.richur.venus.web.concurrent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author richur
 * @since v0.0.1
 */
@Setter
@Getter
public class Client {
    private String version;
    private String description;
    private String jobId;
    private boolean success;

    public String getResult(String jobId) {
        this.jobId = jobId;
        if(success){
            return "result:" + jobId;
        }
        return null;
    }

    public String getJobId() {
        return jobId;
    }

    public String submitJob(String sql) {
        this.jobId = sql.hashCode() + "";
        this.success = false;
        try {
            Thread.sleep(1000);
            this.version = this.version + "1s-";
            Thread.sleep(1000);
            this.version = this.version + "2s-";
            Thread.sleep(1000);
            this.version = this.version + "3s-";
            Thread.sleep(1000);
            this.version = this.version + "4s-";
//            Thread.sleep(1000);
            this.version = this.version + "5s-";
//            Thread.sleep(1000);
            this.version = this.version + "6s-";
//            Thread.sleep(1000);
            this.version = this.version + "7s-";
//            Thread.sleep(1000);
            this.version = this.version + "8s-over";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                Thread.sleep(5000);
                this.success = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        System.out.println(jobId+"+111");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(jobId+"+222");
//        this.success = true;
        return sql.hashCode() + "";
    }
}
