package com.datastructures.dynamicprogramming;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * This problem is about finding the minimum number of coins when there are infinite supply of coin denominations.
 *
 * @author Piyush Kumar.
 * @since 8/25/19.
 */
public class CoinChangeProblemVariation {

    /**
     * This method finds all possible subsets and works in O(2^n).
     * For more details refer this : https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
     * */
    static int getMinimumCoinWithBruteForce(int[] coins, int size, int amount) {

        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {

            if (coins[i] <= amount) {
                int temp_result = 1 + getMinimumCoinWithBruteForce(coins, size, amount - coins[i]);

                if (temp_result < result) {
                    result = temp_result ;
                }
            }
        }

        return result;
    }

    /**
     * This algorithm works in O(size*amount) time complexity and O(size*amount) space complexity.
     */
    static int getMinimumCoinsWithDP1(int[] coins, int size, int amount){

        int[][] solTable = new int[size][amount + 1];


        for (int[] arr : solTable){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int j=0; j < solTable.length; j++){
            solTable[j][0] = 0;
        }

        for (int i=0; i< solTable[0].length; i++){
            solTable[0][i] = i;
        }

        for (int j = 1; j < size; j++) {
            for (int i = 1; i < solTable[j].length; i++) {

                if (coins[j] > i) {
                    solTable[j][i] = solTable[j - 1][i];
                } else {
                    solTable[j][i] = Math.min(1 + solTable[j][i - coins[j]], solTable[j-1][i]);
                }
            }
        }

        for (int[] arr : solTable){
            System.out.println("The solution table is :: " );
            System.out.println(Arrays.toString(arr));
        }
        return solTable[size-1][amount];
    }


    /**
     * This algorithm works in O(size*amount) time complexity and O(amount) space complexity.
     * The above algorithm is further improvised here. The space complexity is reduced to linear.
     */
    static int getMinimumCoinsWithDP2(int[] coins, int size, int amount){

        int[] solTable = new int[amount + 1];

        solTable[0] = 0;
        Arrays.fill(solTable, 1, solTable.length, Integer.MAX_VALUE);

        for (int i = 1; i < solTable.length; i++) {
            for (int j = 0; j<size; j++){

                if (coins[j] <= i) {
                    solTable[i] = Math.min(1 + solTable[i - coins[j]], solTable[i]);
                }
            }
        }

        System.out.println("The solution table is :: " + Arrays.toString(solTable));
        return solTable[amount];
    }


    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int v = 11;
        System.out.println("Minimum coins required is " + getMinimumCoinWithBruteForce(coins, m, v));

        ArrayUtils.reverse(coins); // to get 1,5,6,9 since I need 1 at the start for solving sub problem with 1 coin.
        System.out.println("Minimum coins required with DP1 solution is " + getMinimumCoinsWithDP1(coins, m, v));

        ArrayUtils.reverse(coins); // to get the original elements in the list
        System.out.println("Minimum coins required with DP2 solution is " + getMinimumCoinsWithDP2(coins, m, v));
    }
}
