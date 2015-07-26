package com.datastructures.Queue;

public class QueueOperations {


    public void enqueue(Queue queue, int data) {
        int arr[] = queue.getArr();
        int rear = queue.getRear();
        int front = queue.getFront();
        int size = queue.getSize();

        if (rear + 1 > size - 1) {
            throw new InvalidQueueException("Queue is full");
        }
        if (front == rear) {
            arr[rear + 1] = data;
            System.out.println("enqueued element is " + arr[rear + 1]);
            queue.setFront(0);
            queue.setRear(rear + 1);
        } else {
            arr[rear + 1] = data;
            System.out.println("enqueued element is " + arr[rear + 1]);
            queue.setRear(++rear);
            queue.setArr(arr);

        }
    }

    public void dequeue(Queue queue) {
        int arr[] = queue.getArr();
        int front = queue.getFront();
        int rear = queue.getRear();

        if (front > rear || front == -1) {
            throw new InvalidQueueException("Queue may be empty");
        }
        if (front == 0 && rear == 0) {
            System.out.println("dequeued element is " + arr[front]);
            arr[front] = 0;
            queue.setFront(front + 1);
            queue.setArr(arr);
        } else {
            System.out.println("dequeued element is " + arr[front]);
            arr[front] = 0;
            queue.setFront(front + 1);
            queue.setArr(arr);

        }
    }
}
