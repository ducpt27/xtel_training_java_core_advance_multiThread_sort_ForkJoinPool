package com.xtel.training.threadpool.thread_pool;

public class Task implements Runnable {

    private int id;

    public Task(int id) {
        this.id = id;
    }

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done Task " + id);

    }
}
