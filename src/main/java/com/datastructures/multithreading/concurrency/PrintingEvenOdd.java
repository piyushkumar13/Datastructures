package com.datastructures.multithreading.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintingEvenOdd {

    private boolean isPrintEvenFlag = true;
    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void findEven(int n) {
        lock.lock();

        while (!isPrintEvenFlag) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The even number is :: " + n);
        isPrintEvenFlag = false;
        condition.signalAll();
        lock.unlock();
    }

    public void findOdd(int n) {
        lock.lock();

        while (isPrintEvenFlag) {
            try {
                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The odd number is :: " + n);
        isPrintEvenFlag = true;
        condition.signalAll();

        lock.unlock();
    }
}
