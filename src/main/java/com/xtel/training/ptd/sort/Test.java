package com.xtel.training.ptd.sort;

import com.xtel.training.ptd.common.utils.FileUtils;

import java.util.List;
import java.util.Random;

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
        start_time = System.currentTimeMillis();

        boolean isAppend = false;
        for (int i = 0; i < 5; i++) {
            int[] arr = generateArray(BASE_ARRAY_SIZE/5, BASE_ARRAY_SIZE/5*(i + 1));
            FileUtils.writeNumbers("config/test.txt", arr, isAppend);
            if (!isAppend)
                isAppend = true;
        }

        total_time = System.currentTimeMillis() - start_time;
        System.out.println(String.format("SAVE:  %d ms", total_time));

    }
}
