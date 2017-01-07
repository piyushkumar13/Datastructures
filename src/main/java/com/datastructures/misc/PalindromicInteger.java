package com.datastructures.misc;

/**
 * To check whether number is palindromic numbers. Ex - 121
 */
public class PalindromicInteger {


    private static int isIntegerPalindrome(int number) {

        int reversedNumber = reverseNumber(number);

        if (number == reversedNumber) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int reverseNumber(int number) {
        int rev = 0;
        int temp = 0;
        while (number != 0) {
            temp = number % 10;
            rev = rev * 10 + temp;
            number = number / 10;

        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(isIntegerPalindrome(12211));
    }

}
