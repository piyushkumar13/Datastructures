package com.datastructures.multithreading.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutingClass {

    public static void main(String[] args) {
        PrintingEvenOdd printingEvenOdd = new PrintingEvenOdd();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new EvenClass(10, printingEvenOdd));
        executorService.execute(new OddClass(10, printingEvenOdd));
        executorService.shutdown();
    }
}
