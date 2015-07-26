package com.datastructures.linkedlist;

public class InValidException extends RuntimeException {

    public InValidException(String message){
        super(message);
    }

    public InValidException(String message,Throwable e){
        super(message,e);
    }
}
