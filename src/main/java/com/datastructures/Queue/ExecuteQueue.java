package com.datastructures.Queue;

import java.util.Scanner;

public class ExecuteQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the queue ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        QueueOperations queueOperations = new QueueOperations();
        try {
            queueOperations.enqueue(queue, 10);
            queueOperations.enqueue(queue, 11);
            queueOperations.enqueue(queue, 12);
            queueOperations.enqueue(queue, 13);

            queueOperations.dequeue(queue);
            queueOperations.dequeue(queue);
            queueOperations.dequeue(queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }


}
