package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * Find the number of ways of arrangement of coins(can be different or same) to make the given sum.
 *
 * @author Piyush Kumar.
 * @since 9/2/19.
 */
public class CoinChangeProblem {

    /**
     * This method finds all possible subsets and works in O(2^n).
     * For checking its recursive tree, you can refer this : https://www.geeksforgeeks.org/coin-change-dp-7/
     */
    static int getNumOfWaysToMakeSumBruteForce(int coins[], int size, int value) {

        /* Means no solution */
        if (size < 0 && value >= 1) {
            return 0;
        }

        /* Means no solution */
        if (value < 0) {
            return 0;
        }

        if (value == 0) {
            return 1;
        }

        return getNumOfWaysToMakeSumBruteForce(coins, size - 1, value) + getNumOfWaysToMakeSumBruteForce(coins, size, value - coins[size]);
    }


    /**
     *  This algorithm works in O(size*amount) time complexity and O(size*amount) space complexity.
     */
    static int getNumOfWaysToMakeSumDPSol1(int coins[], int size, int value) {

        int[][] solTable = new int[size + 1][value + 1];

        for (int i = 0; i < solTable[0].length; i++) { // setting 1 in all the cells of 1st row
            solTable[0][i] = 1;
        }
        for (int i = 0; i < solTable.length; i++) { // setting 1 in all the rows 1st column.
            solTable[i][0] = 1;
        }

        for (int i = 1; i < solTable.length; i++) {
            for (int j = 1; j < solTable[i].length; j++) {
                if (coins[i] > j) { // when coin value is greater than actual value, then just copy the value from the above cell.
                    solTable[i][j] = solTable[i - 1][j];

                } else {
                    solTable[i][j] = solTable[i][j - coins[i]] + solTable[i - 1][j];
                }
            }
        }

        System.out.println("The solution table for 'getNumOfWaysToMakeSumDPSol1' is :: ");
        for (int[] arr : solTable) {
            System.out.println(Arrays.toString(arr));
        }
        return solTable[size][value];
    }


    /**
     * This algorithm works in O(size*amount) time complexity and O(amount) space complexity i.e linear.
     *
     *  Note : When your existing row in the DP Solution table(which is of two dimensional size) just makes use of the last
     * row (no other previous rows than the last row), it is quite possible to change that solution with two dimensional array
     * to one dimensional array as a part of further optimization of the space complexity.
     */
    static int getNumOfWaysToMakeSumDPSol2(int coins[], int size, int value) {

        int[] solTable = new int[value + 1];

        for (int i = 0; i < solTable.length; i++) {

            solTable[i] = 1;
        }

        for (int i = 1; i <= size; i++){
            for (int j = 1; j <= value; j++){

                if (coins[i] <= j){
                    solTable[j] = solTable[j] + solTable[j - coins[i]];
                }
            }
        }

        System.out.println("The solution table for 'getNumOfWaysToMakeSumDPSol2' is :: " + Arrays.toString(solTable));
        return solTable[value];
    }


    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int size = coins.length - 1;
        int value = 5;

        int numWays = getNumOfWaysToMakeSumBruteForce(coins, size, value);

        System.out.println("The number of ways to make the sum is ::: " + numWays);

        System.out.println("The number of ways to make the sum is ::: " + getNumOfWaysToMakeSumDPSol1(coins, size, value));

        System.out.println("The number of ways to make the sum is ::: " + getNumOfWaysToMakeSumDPSol2(coins, size, value));
    }
}
