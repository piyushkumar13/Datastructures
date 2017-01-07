package com.datastructures.misc;

/**
 * To find a number which is a multiple of the number passed to function. Number has 3 at its unit place. The result number
 * should be of type like 111 multiple of 3, 111111 multiple of 13.
 */
public class NumEnding3 {


    private static long findNumber(long num) {
        long temp = 1;
        long rem = 1;
        while (rem != 0) {
            temp = (temp * 10 + 1);
            rem = temp % num;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(13));
    }

}
