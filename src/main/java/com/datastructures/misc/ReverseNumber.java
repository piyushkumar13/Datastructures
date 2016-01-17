package com.datastructures.misc;

/* Program to reverse a number */
public class ReverseNumber {

    public static int reverseNumber(int num) {
        int temp;
        int rev = 0;
        while (num != 0) {
            temp = num % 10;
            rev = rev * 10 + temp;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.printf("The reverse of the number %d is %d", 1231, reverseNumber(1231));
    }
}
