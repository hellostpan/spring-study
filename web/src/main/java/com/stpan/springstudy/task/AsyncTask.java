package com.stpan.springstudy.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * author:  STPAN
 * time:    2018/4/12 19:33
 */
@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doTask1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时: "+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(800);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时: "+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时: "+(end-start)+"毫秒");
        return new AsyncResult<>(true);
    }
}
