package com.xtel.training.ptd.common.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static void writeNumbers(String filePath, int[] numbers, boolean isAppend) throws Exception {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("Numbers is empty");

        int size = numbers.length;

        StringBuilder strBuilder = new StringBuilder();

        for (int j = 0; j < size; j++) {
            strBuilder.append(numbers[j]);
            strBuilder.append(" ");
        }

        FileUtils.write(filePath, strBuilder.toString(), isAppend);
    }


    public static void write(String filePath, String str, boolean isAppend) throws IOException {
        Path filePathObj = Paths.get(filePath);

        if (!Files.exists(filePathObj)) {
            Files.write(filePathObj, str.getBytes(), StandardOpenOption.CREATE_NEW);
            return;
        }

        if (isAppend) {
            Files.write(filePathObj, str.getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.delete(filePathObj);
            Files.write(filePathObj, str.getBytes(), StandardOpenOption.CREATE_NEW);
        }
    }

    public static String readLine(String filePath, int lineIndex) throws Exception {
        File f = new File(filePath);

        if (canRead(f)) {
            Scanner scanner = new Scanner(f);
            int i = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (i == lineIndex) return line;
                i++;
            }
        }

        return null;
    }

    public static String[] readAllLine(String filePath) throws Exception {
        File f = new File(filePath);

        ArrayList<String> arr = new ArrayList<String>();

        if (canRead(f)) {
            Scanner scanner = new Scanner(f);

            while (scanner.hasNextLine())
                arr.add(scanner.nextLine());

            scanner.close();
        }

        if (arr.isEmpty()) return null;

        String[] lines = new String[arr.size()];
        return arr.toArray(lines);
    }

    public static List<String> readAllLineByNIO(String filePath) throws Exception {
        Path path = Paths.get(filePath);

        File f = new File(filePath);
        if (!canRead(f))
            return null;

        return Files.readAllLines(path);
    }

    public static boolean canRead(File file) {
        return (file.isFile() && file.exists() && file.canRead());
    }
}
