package com.benson.mall.redbaby.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.benson.mall.redbaby.util
 * Created by Benson on 2017/9/6-下午7:53.
 */

public class ThreadPoolManager {
    private ExecutorService service;

    private ThreadPoolManager() {
        int num = Runtime.getRuntime().availableProcessors();
        service = Executors.newFixedThreadPool(num * 4);
    }

    private static final ThreadPoolManager manager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return manager;
    }

    public void addTask(Runnable runnable) {
        service.execute(runnable);
    }
}