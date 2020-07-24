package com.xtel.training.sort;

import com.xtel.training.common.Numbers;
import com.xtel.training.thread.MyBlockingQueue;
import com.xtel.training.thread.MyThreadPool;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] numbers = Numbers.generateNumbers(50000000, 0);

        MyBlockingQueue myQueueTask = new MyBlockingQueue();

        MyThreadPool myThreadPool = new MyThreadPool(10, myQueueTask);

        QuickSort quickSort = new QuickSort(numbers, myQueueTask);

        System.out.println("Sorting....");
        long start_sort_time = System.currentTimeMillis();

        myThreadPool.execute(quickSort);

        System.out.println("Done! " + (System.currentTimeMillis() - start_sort_time) + "ms");
    }
}
