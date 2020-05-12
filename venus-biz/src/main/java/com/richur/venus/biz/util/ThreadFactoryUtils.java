package com.richur.venus.biz.util;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * @author richur
 * @since v0.0.1
 */
public class ThreadFactoryUtils {
    public static ThreadFactory getThreadFactory(String name) {
        String threadName = name + Thread.currentThread().getId() + "-%d";
        return new ThreadFactoryBuilder().setNameFormat(threadName).build();
    }

    public static ThreadFactory getThreadFactory(String name, Thread.UncaughtExceptionHandler hanlder) {
        String threadName = name + Thread.currentThread().getId() + "-%d";
        return new ThreadFactoryBuilder().setNameFormat(threadName).setUncaughtExceptionHandler(hanlder).build();
    }

    public static ExecutorService getFixedThreadPool(int coreSize, String name) {
        return Executors.newFixedThreadPool(coreSize, getThreadFactory(name));
    }

    public static ExecutorService getSingleThreadPool(String name) {
        return Executors.newSingleThreadExecutor(getThreadFactory(name));
    }

    public static ScheduledExecutorService getSingleThreadScheduleExecutor(String name) {
        return Executors.newSingleThreadScheduledExecutor(getThreadFactory(name));
    }

    public static ListeningExecutorService getListenableFixedThreadPool(int coreSize, String name) {
        return MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(coreSize, getThreadFactory(name)));
    }
}
