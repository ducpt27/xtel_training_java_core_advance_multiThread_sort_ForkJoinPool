package com.xtel.training.producer_consumer;

import com.xtel.training.thread.MyBlockingQueue;

import java.util.Random;

public class MyProducer implements Runnable {

    private MyBlockingQueue<String> queue;

    public MyProducer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void process() throws InterruptedException {
        Random random = new Random();

        for (int j = 1; j < 6; j++) {

            for (int i = 0; i < 100; i++) {
                System.out.println("Producer: " + i);
                queue.put(String.valueOf(i));
                Thread.sleep(random.nextInt(500) + 1);
            }

            Thread.sleep(random.nextInt(10000) + 1);
        }
    }
}
