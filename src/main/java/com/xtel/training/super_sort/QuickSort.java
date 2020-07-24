package com.xtel.training.super_sort;

import com.xtel.training.threadpool.thread_pool.MyQueue;

public class QuickSort implements Runnable {

    private int[] numbers;

    private int left;

    private int right;

    private MyQueue queue;

    public QuickSort(int[] numbers, MyQueue queue) {
        if (numbers == null || queue == null)
            throw new IllegalArgumentException();

        this.numbers = numbers;
        this.left = 0;
        this.queue = queue;
        this.right = numbers.length - 1;
    }

    public QuickSort(int[] numbers, int left, int right, MyQueue queue) {
        this.numbers = numbers;
        this.left = left;
        this.right = right;
        this.queue = queue;
    }

    @Override
    public void run() {
        if (left < right) {
            int pivotIndex = left + ((right - left) / 2);

            pivotIndex = partition(numbers, pivotIndex, left, right);

            try {
                queue.put(new QuickSort(numbers, left, pivotIndex - 1, queue));
                queue.put(new QuickSort(numbers, pivotIndex + 1, right, queue));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int[] getNumbers() {
        return numbers;
    }

    public synchronized int getLeft() {
        return left;
    }

    public synchronized int getRight() {
        return right;
    }

    private static int partition(int[] numbers, int pivotIndex, int l, int r) {
        int pivotValue = numbers[pivotIndex];

        swap(numbers, pivotIndex, r);

        int storeIndex = l;
        for (int i = l; i < r; i++) {
            if (numbers[i] < pivotValue) {
                swap(numbers, i, storeIndex);
                storeIndex++;
            }
        }

        swap(numbers, storeIndex, r);
        return storeIndex;
    }

    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int iValue = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = iValue;
        }
    }
}