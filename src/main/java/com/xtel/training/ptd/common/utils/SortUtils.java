package com.xtel.training.ptd.common.utils;

public class SortUtils {

    public static void quickSort(int[] numbers) {
        _quicksort(numbers, 0, numbers.length - 1);
    }

    private static void _quicksort(int[] numbers, int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {

            while (numbers[i] < pivot)
                i++;
            while (numbers[j] > pivot)
                j--;

            if (i <= j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            _quicksort(numbers, low, j);
        }

        if (i < high) {
            _quicksort(numbers, i, high);
        }
    }

    public static void merge(int[] l, int[] r, int left,
                             int right, int[] numbers) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] < r[j])
                numbers[k++] = l[i++];
            else
                numbers[k++] = r[j++];
        }

        while (i < left)
            numbers[k++] = l[i++];

        while (j < right)
            numbers[k++] = r[j++];
    }


    public static void mergeSort(int[] numbers, int lastIndex) {
        if (lastIndex < 2)
            return;

        int mid = lastIndex / 2;
        int[] l = new int[mid];
        int[] r = new int[lastIndex - mid];

        for (int i = 0; i < mid; i++)
            l[i] = numbers[i];

        for (int i = mid; i < lastIndex; i++)
            r[i - mid] = numbers[i];

        mergeSort(l, mid);
        mergeSort(r, lastIndex - mid);

        merge(l, r, mid, lastIndex - mid, numbers);
    }

    public static void swap(int[] numbers, int i, int j) {
        int iValue = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = iValue;
    }
}
