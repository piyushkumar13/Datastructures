package com.datastructures.multithreading.threadgroup;

public class ThreadGroupExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg1 = new ThreadGroup("Fist group");
        System.out.println("The parent group of tg1 is ::: "+ tg1.getParent().getName());

        MyThread t1 = new MyThread(tg1, "First thread");
        MyThread t2 = new MyThread(tg1, "Second thread");

        ThreadGroup tg2 = new ThreadGroup(tg1,"Second group");
        System.out.println("The parent group of tg2 is ::: "+ tg2.getParent().getName());

        MyThread t3 = new MyThread(tg2, "Third thread");
        MyThread t4 = new MyThread(tg2, "Four thread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        /*
        * In the thread group tg1, there are four threads. Two from tg1 thread group and two from tg1's child
         * thread group tg2. The threads are t1,t2,t3 and t4
        * */
        System.out.println("The no of threads in the tg1 group ::: " + tg1.activeCount());

        /*
        * In the thread group tg2, there are two threads i.e t3 and t4
        * */
        System.out.println("The no of threads in the tg2 group ::: " + tg2.activeCount());

        /*
        * There is only one active child thread group in tg1 is tg2
        * */
        System.out.println("The no of groups in the  group ::: " + tg1.activeGroupCount());

        Thread[] tg1Threads = new Thread[tg1.activeCount()];
        tg1.enumerate(tg1Threads);

        for (Thread t : tg1Threads){
            System.out.println("The name of the thread is ::: " + t.getName());
        }

        Thread[] tg2Threads = new Thread[tg2.activeCount()];
        tg1.enumerate(tg2Threads);

        for (Thread t : tg2Threads){
            System.out.println("The name of the thread is ::: " + t.getName());
        }

        ThreadGroup[] tg1Groups = new ThreadGroup[tg1.activeGroupCount()];
        tg1.enumerate(tg1Groups);

        for (ThreadGroup tg : tg1Groups){
            System.out.println("The threadGroup is ::: "+ tg.getName());
        }
    }
}
