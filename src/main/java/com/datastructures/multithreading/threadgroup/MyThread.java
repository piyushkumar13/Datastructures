package com.datastructures.multithreading.threadgroup;

/**
 * Created by piyushkumar on 19/02/17.
 */
public class MyThread extends Thread {

    public MyThread(ThreadGroup tg, String name) {
        super(tg, name);
    }

    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
