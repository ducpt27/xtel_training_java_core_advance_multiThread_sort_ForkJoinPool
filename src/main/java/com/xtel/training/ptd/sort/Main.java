package com.xtel.training.ptd.sort;

import com.xtel.training.ptd.common.utils.NumberUtils;
import com.xtel.training.ptd.common.utils.SortUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int BASE_ARRAY_SIZE = 50000000;

    public static void main(String[] args) {
        long total_time, start_time;

        for (int i = 0; i < 5; i++) {
            //TEST LOOP
            System.out.println("---- LOOP " + (i + 1) + " ----");

            int[] arr1 = NumberUtils.getNumbers(0, BASE_ARRAY_SIZE, BASE_ARRAY_SIZE);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            int[] arr4 = Arrays.copyOf(arr1, arr1.length);
            int[] arr5 = Arrays.copyOf(arr1, arr1.length);


            //TEST CASE: quickSort()
            start_time = System.currentTimeMillis();

            SortUtils.quickSort(arr1); // SORT

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("QuickSort():  %d ms", total_time));
            // -> ~ 10 second


            //TEST CASE: ForkJoinPool and QuickSort
            QuickSort quickSort = new QuickSort(arr2);
            ForkJoinPool quickSort_pool = new ForkJoinPool();

            start_time = System.currentTimeMillis();

            quickSort_pool.invoke(quickSort); // SORT

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("ForkJoinPool and QuickSort %d ms", total_time));
            // -> ~ 4 second

            //TEST CASE: ForkJoinPool and MergeSort
            MergeSort mergeSort = new MergeSort(arr5);
            ForkJoinPool mergeSort_pool = new ForkJoinPool();

            start_time = System.currentTimeMillis();

            mergeSort_pool.invoke(mergeSort); // SORT

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("ForkJoinPool and MergeSort %d ms", total_time));
            // -> ~ 5.5 second


            //TEST CASE: Arrays.sort()
            start_time = System.currentTimeMillis();

            Arrays.sort(arr3); // SORT

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("Array.sort() %d ms", total_time));
            // -> ~ 8 second


            //TEST CASE: Arrays.parallelSort()
            start_time = System.currentTimeMillis();

            Arrays.parallelSort(arr4); // SORT

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("Arrays.parallelSort() %d ms", total_time));
            // -> ~ 3 second
        }

    }
}