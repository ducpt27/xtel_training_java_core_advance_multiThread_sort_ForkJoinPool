package com.xtel.training.common;

import java.util.Arrays;
import java.util.Random;

public class Numbers {

    public static int[] getSliceOfArray(int[] arr, int startIndex, int endIndex) throws IllegalArgumentException {
        if (arr == null)
            throw new IllegalArgumentException("Array numbers can't be null!");

        if (endIndex - startIndex < 0)
            throw new IllegalArgumentException(endIndex + " > " + startIndex);

        return Arrays.copyOfRange(arr, startIndex, endIndex);
    }


    public static int[] generateNumbers(int capacity, int from) throws IllegalArgumentException {
        if (capacity <= 0)
            throw new IllegalArgumentException();

        Random random = new Random();

        int[] result = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            result[i] = random.nextInt(capacity) + from;
        }

        return result;
    }
}
