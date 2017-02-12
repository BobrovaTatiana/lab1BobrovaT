package com.company;

//        Необходимо разработать программу, которая получает на вход список ресурсов,
//        содержащих набор чисел и считает сумму всех положительных четных.
//        Каждый ресурс должен быть обработан в отдельном потоке, набор должен содержать лишь числа,
// унарный оператор "-" и пробелы.
//        Общая сумма должна отображаться на экране и изменяться в режиме реального времени.
//        Все ошибки должны быть корректно обработаны, все API покрыто модульными тестами

import java.io.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Consumer consumers = new Consumer();

        String[] paths = new String[3];
        paths[0] = "//Users//Tanusha//Desktop//lab.txt";
        paths[1] = "//Users//Tanusha//Desktop//lab2.txt";
        paths[2] = "//Users//Tanusha//Desktop//lab3.txt";

        Thread[] threads = new Thread[paths.length];

        int sum = 0;
        String dataFile = "";

            try {
                for (int i = 0; i < paths.length; i++) {
                    dataFile = openReadFile(paths[i]);
                    threads[i] = new Thread(new Summator(dataFile, consumers));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        for (Thread th:threads) {
            th.start();
        }

        for (Thread th:threads) {
            th.join();
        }
        if (consumers.err = false) {
            System.out.println("\n" + "Итоговая сумма: " + consumers.summ);
        }
    }

    public static String openReadFile(String path) throws IOException {
        String dataFile = new String();
        FileInputStream file = new FileInputStream(path);
        byte[] buffer = new byte[file.available()];
        file.read(buffer, 0, file.available());
        dataFile = new String(buffer);
        return dataFile;
    }
}