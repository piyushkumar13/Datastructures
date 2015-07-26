package com.datastructures.Queue;

public class InvalidQueueException extends RuntimeException {

    public InvalidQueueException(String message) {
        super(message);
    }

    public InvalidQueueException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
