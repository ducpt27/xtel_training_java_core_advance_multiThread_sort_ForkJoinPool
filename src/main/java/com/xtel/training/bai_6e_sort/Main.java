package com.xtel.training.bai_6e_sort;

import com.xtel.training.common.utils.NumberUtil;
import com.xtel.training.thread.MyBlockingQueue;
import com.xtel.training.thread.MyThreadPool;

public class Main {

    public static void main(String[] args) throws Exception {

        int[] numbers = NumberUtil.generateNumbers(500, 0);

        MyBlockingQueue myQueueTask = new MyBlockingQueue();

        MyThreadPool myThreadPool = new MyThreadPool(5, myQueueTask);

        QuickSort quickSort = new QuickSort(numbers, myQueueTask);

        System.out.println("Sorting....");
        long start_sort_time = System.currentTimeMillis();

        myThreadPool.execute(quickSort);
    }
}
