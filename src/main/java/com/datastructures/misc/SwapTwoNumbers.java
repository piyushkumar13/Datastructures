package com.datastructures.misc;

/* Programme to swap two numbers. */
public class SwapTwoNumbers {

    int a;
    int b;

    public SwapTwoNumbers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /* Swapping two numbers using the third variable. */
    public void swapTwoNumbers(SwapTwoNumbers obj) {
        int temp;
        temp = obj.a;
        obj.a = obj.b;
        obj.b = temp;
    }

    /* Swapping two numbers without using third variable. */
    public void swapTwoNumbersWithoutTempVar(SwapTwoNumbers obj) {
        obj.a = obj.a + obj.b;
        obj.b = obj.a - obj.b;
        obj.a = obj.a - obj.b;
    }

    public static void main(String[] args) {

        SwapTwoNumbers obj = new SwapTwoNumbers(10, 12);
        System.out.println("The value before swapping");
        System.out.printf("The value of a : %d and b : %d", obj.a, obj.b);
        System.out.println();

        obj.swapTwoNumbers(obj);

        System.out.println("The value after swapping");
        System.out.printf("The value of a : %d and b : %d", obj.a, obj.b);

        System.out.println();
        System.out.println("Swapping two numbers without using third variable");
        obj.swapTwoNumbersWithoutTempVar(obj);
        System.out.printf("The value of a : %d and b : %d", obj.a, obj.b);
    }
}

