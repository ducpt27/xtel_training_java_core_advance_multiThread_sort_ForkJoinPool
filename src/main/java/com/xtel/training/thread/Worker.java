package com.xtel.training.thread;

public class Worker extends Thread {

    boolean shutdownSignal = false;

    boolean isRun = false;

    MyBlockingQueue<Runnable> queue;

    public Worker(MyBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public synchronized void start() {
        isRun = true;
        super.start();
    }

    @Override
    public void run() {
        Runnable task;

        while (isRun) {
            try {
                if (shutdownSignal && queue.isEmpty())
                    break;

                task = queue.take();

                if (task != null) {
                    task.run();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("---- " +  Thread.currentThread().getName() + " ---- ");
    }
}
