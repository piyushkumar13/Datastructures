package com.datastructures.stack;


import java.util.Scanner;

public class ExecuteStack {

    public static void main(String[] args) {

        System.out.println("Enter the size of the stack : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        System.out.println("Pushing into the stack");
        StackOperations stackOperations = new StackOperations();
        stackOperations.push(10,stack);
        stackOperations.push(11,stack);
        stackOperations.push(12,stack);
        stackOperations.push(13,stack);

        System.out.println("Popping from the stack");
        stackOperations.pop(stack);
        stackOperations.pop(stack);

        System.out.println("Printing whole stack");
        stackOperations.printStack(stack);
    }
}
