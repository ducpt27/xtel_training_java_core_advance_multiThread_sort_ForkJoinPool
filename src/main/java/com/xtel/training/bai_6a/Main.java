package com.xtel.training.bai_6a;

import java.util.Scanner;

public class Main {

    static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String command = null;
        SetNumberThread setNumberThread = new SetNumberThread();

        System.out.println("Bắt đầu in số!");
        System.out.println("Nhập stop để dừng in số ra file");

        setNumberThread.start();

        while (true) {
            command = SCANNER.nextLine();
            if (command.trim().equalsIgnoreCase("stop")) {
                setNumberThread.setStop();
                return;
            }
        }
    }
}
