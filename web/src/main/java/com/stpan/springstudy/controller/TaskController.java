package com.stpan.springstudy.controller;

import com.stpan.springstudy.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * author:  STPAN
 * time:    2018/4/12 19:38
 */
@RestController
@RequestMapping("task/")
public class TaskController {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask1();
        Future<Boolean> b = asyncTask.doTask2();
        Future<Boolean> c = asyncTask.doTask3();
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);

        return times;
    }
}
