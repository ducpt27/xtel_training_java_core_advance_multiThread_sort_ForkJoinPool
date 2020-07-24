package com.xtel.training.super_sort;

import com.xtel.training.threadpool.thread_pool.MyQueue;
import com.xtel.training.threadpool.thread_pool.MyThreadPool;

import java.util.Random;

public class Main {

    public static int[] generateNumbers(int capacity, int from) {
        if (capacity <= 0)
            throw new IllegalArgumentException();

        Random random = new Random();

        int[] result = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            result[i] = random.nextInt(capacity) + from;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(5);
        MyThreadPool threadPool = new MyThreadPool(10, queue);

        // Tạo mảng số
        int[] numbers = generateNumbers(50000000, 0);

        QuickSort quickSort = new QuickSort(numbers, queue);

        // Sắp xếp số
        System.out.println("Sorting....");

        long start_time = System.currentTimeMillis();
        threadPool.execute(quickSort);

        // join multi thread
        long total_sort_time = System.currentTimeMillis() - start_time;
//        System.out.println("Done: " + total_sort_time + "ms");

        Thread.currentThread().sleep(10000);
        threadPool.shutdown();

        // Hiển thị
        for (int i = 50000000 - 500; i < 50000000 - 450; i++) {
            System.out.println(quickSort.getNumbers()[i]);
        }
    }
}
