package com.datastructures.misc;

/* Sum of digits in a number. */
public class SumOfDigits {

    public static int sumOfDigits(int num) {

        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static int sumOfDigitsWithRecursion(int num) {
        int sum = num % 10;

        if (num != 0) {
            sum = sum + sumOfDigitsWithRecursion(num / 10);
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = sumOfDigits(172);

        System.out.println("The sum of the digits is : " + sum);

        System.out.println("The sum of digits through recursive method is : " + sumOfDigitsWithRecursion(1));
    }
}
