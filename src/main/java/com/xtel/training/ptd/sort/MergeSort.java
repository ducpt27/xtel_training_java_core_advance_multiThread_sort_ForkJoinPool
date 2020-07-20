package com.xtel.training.ptd.sort;

import java.util.concurrent.RecursiveAction;

public class MergeSort extends RecursiveAction {

    private int array[];
    private int left;
    private int right;

    public MergeSort(int[] array) {
        this.array = array;
        this.left = 0;
        this.right = array.length - 1;
    }

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int mid = (left + right) / 2;

            invokeAll(new MergeSort(array, left, mid),
                    new MergeSort(array, mid + 1, right));

            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {

        int arr_temp [] = new int[right - left + 1];

        int x = left;
        int y = mid + 1;
        int z = 0;

        while (x <= mid && y <= right) {
            if (array[x] <= array[y])
                arr_temp[z++] = array[x++];
            else
                arr_temp[z++] = array[y++];
        }

        while (y <= right)
            arr_temp[z++] = array[y++];

        while (x <= mid)
            arr_temp[z++] = array[x++];

        for (z = 0; z < arr_temp.length; z++)
            array[left + z] = arr_temp[z];
    }
}
