package com.xtel.training.ptd.sort;

import com.xtel.training.ptd.common.utils.FileUtils;
import com.xtel.training.ptd.common.utils.SortUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Test {

    private static final int BASE_ARRAY_SIZE = 50000000;

    public static int[] generateArray(int size, int from) {
        Random random = new Random();
        if (size <= 0 || size > Integer.MAX_VALUE)
            return null;

        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = random.nextInt(BASE_ARRAY_SIZE) + from;

        return result;
    }


    public static void main(String[] args) throws Exception {

        long total_time, start_time;

//        WRITE FILE
//        start_time = System.currentTimeMillis();
//
//        boolean isAppend = false;
//        for (int i = 0; i < 5; i++) {
//            int[] arr = generateArray(BASE_ARRAY_SIZE/5, BASE_ARRAY_SIZE/5*(i + 1));
//            FileUtils.writeNumbers("config/test.txt", arr, isAppend);
//            if (!isAppend)
//                isAppend = true;
//        }
//
//        total_time = System.currentTimeMillis() - start_time;
//        System.out.println(String.format("SAVE:  %d ms", total_time));

//        int[] arr1 = generateArray(BASE_ARRAY_SIZE, 0);
//
//        MergeSort mergeSort = new MergeSort(arr1);
//        ForkJoinPool pool = new ForkJoinPool();
//
//        start_time = System.currentTimeMillis();
//
//        pool.invoke(mergeSort);
//
//        total_time = System.currentTimeMillis() - start_time;
//        System.out.println(String.format("SAVE:  %d ms", total_time));
//
//        for (int i = 0; i < 50; i++) {
//            System.out.printf(arr1[i] + " ");
//        }
//        System.out.println("");
    }
}
