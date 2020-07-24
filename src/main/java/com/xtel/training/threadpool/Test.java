package com.xtel.training.threadpool;

import com.xtel.training.threadpool.thread_pool.MyQueue;
import com.xtel.training.threadpool.thread_pool.MyThreadPool;
import com.xtel.training.threadpool.thread_pool.Task;

public class Test {

    public static void main(String[] args) throws Exception {

        MyThreadPool threadPool = new MyThreadPool(5, new MyQueue<>(10));

        Task task;

        for (int i = 0; i < 200; i++) {
            task = new Task(i);
            threadPool.execute(task);
        }

        System.out.println("SLEEP");
        Thread.currentThread().sleep(3000);

        for (int i = 200; i < 405; i++) {
            task = new Task(i);
            threadPool.execute(task);
        }

        threadPool.shutdown();
    }
}
