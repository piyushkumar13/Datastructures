package com.datastructures.dynamicprogramming;

public class FibonacciSeries {

    private static int fib1[] = new int[10];
    private static int fib2[] = new int[10];

    /* Without using Dynamic Programming */
    public static int fibonacciGenerator(int n) {

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacciGenerator(n - 1) + fibonacciGenerator(n - 2);
        }
    }

    /* Using Dynamic Programming with top-down approach */
    public static int fibonacciGeneratorWithDp(int n) {

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (fib1[n] != 0) {
            return fib1[n];
        } else {
            return fib1[n] = fibonacciGeneratorWithDp(n - 1) + fibonacciGeneratorWithDp(n - 2);
        }
    }

    /* Using Dynamic Programming with bottom-up approach */
    public static int[] fibonacciGeneratorWithDpInBottomUp(int n) {

        if (n == 1) {
            fib2[0] = 0;
            return fib2;
        } else if (n == 2) {
            fib2[1] = 1;
            return fib2;
        }

        fib2[0] = 0;
        fib2[1] = 1;
        for (int i = 2; i < n; i++) {
            fib2[i] = fib2[i - 1] + fib2[i - 2];
        }
        return fib2;
    }

    public static void main(String[] args) {

        System.out.println("Printing nth fibonacci number without using DP : ");
        System.out.println(fibonacciGenerator(1));
        System.out.println(fibonacciGenerator(2));
        System.out.println(fibonacciGenerator(3));
        System.out.println(fibonacciGenerator(4));
        System.out.println(fibonacciGenerator(5));
        System.out.println(fibonacciGenerator(6));

        System.out.println("Printing nth fibonacci number using DP - top down approach : ");
        System.out.println(fibonacciGeneratorWithDp(1));
        System.out.println(fibonacciGeneratorWithDp(2));
        System.out.println(fibonacciGeneratorWithDp(3));
        System.out.println(fibonacciGeneratorWithDp(4));
        System.out.println(fibonacciGeneratorWithDp(5));
        System.out.println(fibonacciGeneratorWithDp(6));

        System.out.println("Printing fibonacci series usign DP - bottom up approach");

        int fibSeries[] = fibonacciGeneratorWithDpInBottomUp(3);
        for (int i : fibSeries) {
            System.out.println(i);
        }
    }
}
