package com.xtel.training.bai_6c_producer_consumer;

import com.xtel.training.thread.MyBlockingQueue;

import java.util.Random;

public class MyConsumer implements Runnable {

    private MyBlockingQueue<String> queue;

    public MyConsumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = queue.take();
                process(item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void process(String item) throws InterruptedException {
        Random random = new Random();
        Thread.sleep(random.nextInt(1000) + 1);
        System.out.println("-- Consumer take: " + item);
    }
}