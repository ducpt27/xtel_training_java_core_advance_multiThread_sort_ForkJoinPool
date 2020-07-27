package com.xtel.training.bai_6c_producer_consumer;

import com.xtel.training.thread.MyBlockingQueue;

public class Main {

    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue(5);

        MyProducer producer = new MyProducer(queue);
        MyConsumer consumer = new MyConsumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
