package com.xtel.training.ptd.common.utils;

import java.util.ArrayList;
import java.util.Random;

public class NumberUtils {

    static final Random RANDOM = new Random();

    public static int[] getNumbers(int low, int range, int total) {
        if (total <= 0) throw new IllegalArgumentException("Total muse be greater than 0");
        int[] numbers = new int[total];
        for (int i = 0; i < total; i++) {
            numbers[i] = getNumber(low, range);
        }
        return numbers;
    }

    public static int getNumber(int low, int range) {
        if (range <= 0) throw new IllegalArgumentException("Range must be greater than 0");
        return RANDOM.nextInt(range) + low;
    }

    public static int[] parseInt(String[] array) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        for (String str : array) {
            arr.add(NumberUtils.parseInt(str));
            i++;
        }
        int[] numbers = new int[i+1];
        return numbers;
    }

    public static int parseInt(String str) throws Exception {
        return Integer.parseInt(str);
    }

    public static int[] parseInts(String str, String regex) throws Exception {
        String[] strings = StringUtils.splitWords(str, regex);
        return NumberUtils.parseInt(strings);
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
