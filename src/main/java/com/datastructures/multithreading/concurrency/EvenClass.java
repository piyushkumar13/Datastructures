package com.datastructures.multithreading.concurrency;

public class EvenClass implements Runnable {

    private PrintingEvenOdd printingEvenOdd;
    private int n;

    public EvenClass(int n, PrintingEvenOdd printingEvenOdd) {
        this.n = n;
        this.printingEvenOdd = printingEvenOdd;
    }

    @Override
    public void run() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                printingEvenOdd.findEven(i);
            }
        }
    }
}
