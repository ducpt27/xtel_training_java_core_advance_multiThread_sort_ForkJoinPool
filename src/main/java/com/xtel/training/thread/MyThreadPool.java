package com.xtel.training.thread;

public class MyThreadPool {

    private final int poolSize;

    private MyBlockingQueue<Runnable> queueTasks;

    private Worker[] threads;

    boolean shutdownSignal = false;

    public MyThreadPool(int poolSize) {
        this(poolSize, new MyBlockingQueue());
    }

    public MyThreadPool(int poolSize, MyBlockingQueue<Runnable> queueTasks) {
        if (poolSize <= 0)
            throw new IllegalArgumentException();

        if (queueTasks == null)
            throw new NullPointerException();

        this.poolSize = poolSize;
        this.queueTasks = queueTasks;
        this.threads = new Worker[poolSize];

        initWorker();
    }

    private void initWorker() {
        for (int i = 0; i < poolSize; i++) {
            threads[i] = new Worker(queueTasks);
            threads[i].start();
        }
    }

    public void execute(Runnable task) throws Exception {
        if (task == null)
            throw new NullPointerException();

        if (shutdownSignal) {
            throw new InterruptedException("Thread pool đã tắt, không thể thực thi tác vụ!");
        } else {
            queueTasks.put(task);
        }
    }

    public void shutdown() {
        shutdownSignal = true;

        for (int i = 0; i < poolSize; i++) {
            threads[i].shutdownSignal = true;
        }
    }
}
