package com.xtel.training.threadpool.thread_pool;

public class MyThreadPool {

    private final int poolSize;

    private MyQueue<Runnable> queue;

    private Worker[] threads;

    boolean shutdownSignal = false;

    public MyThreadPool(int poolSize) {
        this(poolSize, new MyQueue());
    }

    public MyThreadPool(int poolSize, MyQueue<Runnable> queue) {
        if (poolSize <= 0)
            throw new IllegalArgumentException();

        if (queue == null)
            throw new NullPointerException();

        this.poolSize = poolSize;
        this.queue = queue;
        this.threads = new Worker[poolSize];

        initWorker();
    }

    private void initWorker() {
        for (int i = 0; i < poolSize; i++) {
            threads[i] = new MyThreadPool.Worker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) throws Exception {
        if (task == null)
            throw new NullPointerException();

        if (!shutdownSignal)
            queue.put(task);
        else
            throw new InterruptedException("Thread pool đã tắt, không thể thực thi tác vụ!");
    }

    public void shutdown() {
        shutdownSignal = true;

        for (int i = 0; i < poolSize; i++) {
            threads[i].shutdownSignal = true;
        }
    }

    class Worker extends Thread {

        boolean shutdownSignal = false;

        @Override
        public void run() {
            Runnable task;

            while (true) {
                try {
                    if (shutdownSignal && queue.isEmpty())
                        break;

                    task = queue.take();

                    if (task != null)
                        task.run();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("---- " +  Thread.currentThread().getName() + " ---- ");
        }
    }
}
