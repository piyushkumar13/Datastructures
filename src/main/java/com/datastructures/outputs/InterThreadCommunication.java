package com.datastructures.outputs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Queue {

    int n = 0;

    volatile boolean flag = true;

    public synchronized void enqueue() {
        if (!flag) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        n++;
        System.out.println("enqeue value is " + n);
        flag = false;
        notify();
    }

    public synchronized void dequeue() {

        if (flag) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        --n;
        System.out.println("deque value is " + n);
        flag = true;
        notify();
    }

}

class Consumer implements Runnable {
    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.dequeue();

        }

    }
}

class Producer implements Runnable {
    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;

    }

    @Override
    public void run() {

        while (true) {
            queue.enqueue();

        }

    }
}


public class InterThreadCommunication {

    public static void main(String[] args) {

        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(producer);
        executorService.execute(consumer);

    }
}
