package com.richur.venus.biz.util.test;

import com.alibaba.fastjson.JSON;
import com.richur.venus.biz.util.ThreadFactoryUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Clock;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author richur
 * @since v0.0.1
 */
public class HttpTest {

    private Logger LOGGER = LoggerFactory.getLogger(HttpTest.class);

    public static void main(String[] args) {

        HttpTest httpTest = new HttpTest();

        for(int i=0; i< 2000;i++) {//todo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            httpTest.threadSubmit();
        }

    }

    private void threadSubmit(){
        AutoExecuteDTO autoExecuteDTO = new AutoExecuteDTO();
        autoExecuteDTO.setHdfsSave(false);
        autoExecuteDTO.setJobType(19);
        autoExecuteDTO.setSql("show databases");
        ExecutorService executorService = new ThreadPoolExecutor(8, 200,0,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1),
                ThreadFactoryUtils.getThreadFactory("auto-dispatcher-protocol-thread-test-" + Clock.systemDefaultZone().millis()));
        for(int i=0; i< 50;i++){//todo
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            ExecutorService executorService1 = Executors.newSingleThreadExecutor(ThreadFactoryUtils.getThreadFactory("auto-dispatcher-protocol-thread-" + Clock.systemDefaultZone().millis()));
            executorService.submit(() -> postTest(autoExecuteDTO));
        }
    }


    private void postTest(AutoExecuteDTO autoExecuteDTO){
        String url="http://lancer.berserker.bilibili.co:8080/sql/execute";
        Connection.Response response = post(url, JSON.toJSONString(autoExecuteDTO));
        String executeResponse = response.body();
        LOGGER.info("{} - * - {}", new Date(), response.body());

        AutoExecuteVO vo = JSON.parseObject(executeResponse, AutoExecuteVO.class);
        Long historyProjectId = vo.getHistoryProjectId();

        AutoResultDTO autoResultDTO1 = new AutoResultDTO();
        autoResultDTO1.setHistoryProjectId(historyProjectId);
        autoResultDTO1.setOffset(0);
        autoResultDTO1.setOffsetTag("");

        String resultUrl = "http://lancer.berserker.bilibili.co:8080/sql/result";
        int status = 4;
        while(status != 1){

            Connection.Response resultResponse = post(resultUrl, JSON.toJSONString(autoResultDTO1));
            String resultResponseStr = resultResponse.body();

            AutoResultVO autoExecuteVO = JSON.parseObject(resultResponseStr, AutoResultVO.class);
            autoResultDTO1.setOffset(autoExecuteVO.getOffset());
            autoResultDTO1.setOffsetTag(autoExecuteVO.getOffsetTag());

            status = autoExecuteVO.getStatus();
            LOGGER.info("{}", resultResponseStr);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private Connection.Response post(String url, String body){
        Connection connection = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36") // User-Agent of Chrome 55
                .header("Content-Type", "application/json;charset=UTF-8")
                .ignoreContentType(true)
                .cookie("username","liulei01")
                .cookie("_AJSESSIONID", "8c1fc22aa57804edeeae736308dfa7d1")
                .header("Connection", "keep-alive")
                .header("X-Requested-With", "XMLHttpRequest")
                .requestBody(body)
                //.maxBodySize(100)
                .timeout(1000 * 10)
                .method(Connection.Method.POST);

        try {
            return connection.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
