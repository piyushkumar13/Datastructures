package com.datastructures.dynamicprogramming;

/**
 * @author Piyush Kumar.
 * @since 10/2/19.
 */
public class RodCuttingProblem {

    /**
     * This method find all possible subsets and works in O(2^n).
     * For more details refer this : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
     */
    public static int getMaxProfitForCuttingBruteForce(int[] arr, int rodLen) {

        if (rodLen <= 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < rodLen; i++) {
            int profit = arr[i] + getMaxProfitForCuttingBruteForce(arr, rodLen - i - 1);

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * This algorithm works in time complexity O(profitValues*size) and space complexity O(profitValues*size).
     */
    public static int getMaxProfitForCuttingDP(int[] profitValues, int size) {

        int[][] solTable = new int[profitValues.length][size + 1];

        for (int i = 0; i <= size; i++) {
            solTable[0][i] = i * profitValues[0]; // Profit value of length 1(length 1 = index of profitValues array + 1) * different rod sizes.
        }

        for (int i = 1; i < solTable.length; i++) {
            for (int j = 1; j <= size; j++) {
                if (j < (i + 1)) {

                    solTable[i][j] = solTable[i - 1][j];
                } else {
                    solTable[i][j] = Math.max(profitValues[i] + solTable[i - 1][j - (i + 1)], solTable[i - 1][j]);
                }
            }
        }

        return solTable[profitValues.length - 1][size];
    }


    /**
     * This algorithm further optimizes the space complexity.
     * This will work in time complexity O(size*size) and space complexity O(size).
     */
    public static int getMaxProfitForCuttingDP2(int[] profitValues, int size) {

        int[] solTable = new int[size + 1];

        solTable[0] = 0;

        for (int i = 1; i < solTable.length; i++) {
            int maxVal = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {

                maxVal = Math.max(maxVal, profitValues[j] + solTable[i - (j + 1)]);
            }
            solTable[i] = maxVal;
        }

        return solTable[size];
    }


    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Allowed cutting lengths = arr index + 1");
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                getMaxProfitForCuttingBruteForce(arr, size));

        System.out.println("Using DP, solution1 is ::: " + getMaxProfitForCuttingDP(arr, size));
        System.out.println("Using DP, solution2 is ::: " + getMaxProfitForCuttingDP2(arr, size));

    }

}
