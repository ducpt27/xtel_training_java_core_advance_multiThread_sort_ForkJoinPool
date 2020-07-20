package com.xtel.training.ptd.sort;

import com.xtel.training.ptd.common.utils.SortUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int BASE_ARRAY_SIZE = 50000000;

    public static int[] generateArray(int size) {
        Random random = new Random();
        if (size <= 0 || size > Integer.MAX_VALUE)
            return null;

        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = random.nextInt(BASE_ARRAY_SIZE);

        return result;
    }

    public static void main(String[] args) {

        long total_time, start_time;

        //TEST: LOOP
        for (int i = 0; i < 5; i++) {
            System.out.println("---- LOOP " + (i+1) + " ----");

            int[] arr1 = generateArray(BASE_ARRAY_SIZE);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            int[] arr4 = Arrays.copyOf(arr1, arr1.length);


            //TEST CASE: quickSort()
            start_time = System.currentTimeMillis();

            SortUtils.quickSort(arr1);

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("QuickSort():  %d ms", total_time));


            //TEST CASE: ForkJoinPool and QuickSort
            start_time = System.currentTimeMillis();

            QuickSort quickSort = new QuickSort(arr2);
            ForkJoinPool pool = new ForkJoinPool();
            pool.invoke(quickSort);

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("ForkJoinPool and QuickSort() %d ms", total_time));


            //TEST CASE: Arrays.sort()
            start_time = System.currentTimeMillis();

            Arrays.sort(arr3);

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("Array.sort() %d ms", total_time));


            //TEST CASE: Arrays.parallelSort()
            start_time = System.currentTimeMillis();

            Arrays.parallelSort(arr4);

            total_time = System.currentTimeMillis() - start_time;
            System.out.println(String.format("Array.parallelSort() %d ms", total_time));
        }

    }
}