package com.xtel.training.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NumberUtil {

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

    public static Integer[] parseInt(String[] array) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        for (String str : array) {
            Integer number = NumberUtil.parseInt(str);
            if (number != null) arr.add(number);
        }
        Integer[] numbers = new Integer[arr.size()];
        arr.toArray(numbers);
        return numbers;
    }

    public static Integer parseInt(String str) throws Exception {
        if (str == null) return null;
        return Integer.parseInt(str);
    }

    public static Double parseDouble(String str) throws Exception {
        if (str == null) return null;
        return Double.parseDouble(str);
    }

    public static boolean compare(Number n1, Number n2) {
        if (n1 == null || n2 == null) return false;
        return n1.equals(n2);
    }

    public static boolean isNullOrEmpty(Integer[] arr) {
        return (arr == null || arr.length == 0);
    }
}
