package com.datastructures.stack;

public class Stack {

    int arr[];
    int top;
    int size;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        this.top = -1;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
