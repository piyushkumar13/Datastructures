package com.datastructures.dynamicprogramming;

import org.apache.commons.lang.ArrayUtils;

/**
 * Find the number of ways of arrangement of coins(can be different or same) to make the given sum.
 *
 * @author Piyush Kumar.
 * @since 9/2/19.
 */
public class CoinChangeProblem {

    /* This is a brute force approach. It will work in exponential time complexity. */
    static int getNumOfWaysToMakeSum(int coins[], int size, int value){

        /* Means no solution */
        if (size < 0 && value >=1){
            return 0;
        }

        /* Means no solution */
        if (value < 0){
            return 0;
        }

        if (value == 0){
            return 1;
        }

        return getNumOfWaysToMakeSum(coins, size-1, value) + getNumOfWaysToMakeSum(coins, size, value - coins[size]);
    }


    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int size = coins.length - 1;
        int value = 5;

        int numWays = getNumOfWaysToMakeSum(coins, size, value);

        System.out.println("The number of ways to make the sum is ::: " + numWays);

    }

}
