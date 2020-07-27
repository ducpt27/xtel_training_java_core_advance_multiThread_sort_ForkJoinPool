package com.xtel.training.bai_6e_sort;

import com.xtel.training.thread.MyBlockingQueue;

public class QuickSort implements Runnable {

    private int[] numbers;

    private int left;

    private int right;

    private MyBlockingQueue queue;

    private boolean isDone = false;

    public QuickSort(int[] numbers, MyBlockingQueue queue) {
        if (numbers == null || queue == null)
            throw new IllegalArgumentException();

        this.numbers = numbers;
        this.left = 0;
        this.queue = queue;
        this.right = numbers.length - 1;
    }

    public QuickSort(int[] numbers, int left, int right, MyBlockingQueue queue) {
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

            QuickSort q1, q2;
            try {
                q1 = new QuickSort(numbers, left, pivotIndex - 1, queue);
                q2 = new QuickSort(numbers, pivotIndex + 1, right, queue);

                queue.put(q1);
                queue.put(q2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public boolean isDone() {
        return isDone;
    }

    public int[] getNumbers() {
        return numbers;
    }
}