package com.datastructures.stack;

public class StackOperations {

    public void push(int data, Stack stack) {

        if (stack.getTop() > stack.getSize() - 1) {
            throw new InValidStackException("stack overflow");
        }
        int stArr[] = stack.getArr();
        int top = stack.getTop();
        stArr[++top] = data;
        stack.setTop(top);
        stack.setArr(stArr);
        System.out.println("pushed value is " + data);
    }

    public void pop(Stack stack) {

        if (stack.getTop() < 0) {
            throw new InValidStackException("stack underflow");
        }
        int stArr[] = stack.getArr();
        int top = stack.getTop();
        int entry = stArr[top];
        stArr[top--] = 0;
        System.out.println("removed value is : " + entry);
        stack.setTop(top);
        stack.setArr(stArr);
    }

    public void printStack(Stack stack) {
        int arr[] = stack.getArr();
        int top = stack.getTop();
        System.out.println("Printing the whole stack");
        if (stack.getTop() == -1) {
            System.out.println("Stack is empty");
            System.exit(0);
        }

        while (top > -1) {
            System.out.println(arr[top--]);
        }

    }
}
