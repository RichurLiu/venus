package com.richur.venus.biz.util.thread.parallel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

/**
 * @author richur
 */
@Slf4j
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Thread(() -> {
            log.info("complete");
        }));

        for (int i = 0; i < threadNum; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    log.info("{} start to handle.", finalI);
                    Thread.sleep(2000);
                    log.info("{} end to handle.", finalI);
                    barrier.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
