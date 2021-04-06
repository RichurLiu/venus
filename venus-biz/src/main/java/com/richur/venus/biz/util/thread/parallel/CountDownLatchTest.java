package com.richur.venus.biz.util.thread.parallel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author richur
 */
@Slf4j
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行……");
        ExecutorService esOne = Executors.newSingleThreadExecutor();
        ExecutorService esTwo = Executors.newSingleThreadExecutor();
        esOne.execute(new Thread(() -> {
            log.info("子线程1:{} 开始执行.", Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("子线程1:{} 执行结束.", Thread.currentThread().getName());
            log.info("1-latch count:{},", latch.getCount());
            latch.countDown();

        }));
        esOne.shutdown();
        esTwo.execute(new Thread(() -> {
            log.info("子线程2:{} 开始执行.", Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("子线程2:{} 执行结束.", Thread.currentThread().getName());
            log.info("2-latch count:{},", latch.getCount());
            latch.countDown();
        }));
        esTwo.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("子线程执行完毕:{}", latch.getCount());

    }
}
