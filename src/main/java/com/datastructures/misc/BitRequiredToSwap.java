package com.datastructures.misc;

/**
 * To find number of bits required to set to convert x to y.
 */
public class BitRequiredToSwap {

    private static int bitSwapReqd(int x, int y) {
        int count = 0;
        for (int z = x ^ y; z != 0; z = z >> 1) {
            count += z & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitSwapReqd(111, 8));
    }
}
