package com.xtel.training.ptd.sort;

import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction {

    private int[] data;
    private int left;
    private int right;

    public QuickSort(int[] data) {
        this.data = data;
        this.left = 0;
        this.right = data.length - 1;
    }

    public QuickSort(int[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivotIndex = left + ((right - left) / 2);

            pivotIndex = partition(pivotIndex);

            invokeAll(new QuickSort(data, left, pivotIndex - 1),
                    new QuickSort(data, pivotIndex + 1, right));
        }

    }

    private int partition(int pivotIndex) {
        int pivotValue = data[pivotIndex];

        swap(pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (data[i] < pivotValue) {
                swap(i, storeIndex);
                storeIndex++;
            }
        }

        swap(storeIndex, right);

        return storeIndex;
    }

    private void swap(int i, int j) {
        if (i != j) {
            int iValue = data[i];
            data[i] = data[j];
            data[j] = iValue;
        }
    }
}
