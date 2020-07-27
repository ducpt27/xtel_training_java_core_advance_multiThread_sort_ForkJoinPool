package com.xtel.training.bai_6b;


import com.xtel.training.common.utils.NumberUtil;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int second;
        PrintNumberThread printNumberThread = new PrintNumberThread();

        System.out.println("Nhập số giây muốn dừng in:");
        try {
            second = NumberUtil.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai số!");
            return;
        }
        if (second <= 0) return;

        System.out.println("Bắt đầu in số ra màn hình");
        printNumberThread.start();

        TimerTask stopThreadPrintNumber = new TimerTask() {
            public void run() {
                printNumberThread.setStop();
                System.out.println("Dừng in số!");
            }
        };
        Timer timer = new Timer();
        timer.schedule(stopThreadPrintNumber, second * 1000);
    }
}
