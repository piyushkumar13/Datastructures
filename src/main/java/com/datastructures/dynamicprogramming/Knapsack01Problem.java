package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 10/8/19.
 */
public class Knapsack01Problem {

    /**
     * This method find all possible subsets and works in O(2^n).
     * For checking its recursive tree, you can refer this : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
     */
    public static int findMaxProfitBruteForce(int sackWeight, int[] wts, int[] values, int size) {

        if (sackWeight == 0 || size == 0) {
            return 0;
        }

        if (wts[size - 1] > sackWeight) {
            return findMaxProfitBruteForce(sackWeight, wts, values, size - 1);
        } else {
            return Math.max(findMaxProfitBruteForce(sackWeight, wts, values, size - 1),
                    values[size - 1] + findMaxProfitBruteForce(sackWeight - wts[size - 1], wts, values, size - 1));
        }
    }

    /**
     * This method find all possible subsets and works in O(2^n).
     * But this method uses recursive call within a loop.
     */
    public static int findMaxProfitBruteForce2(int sackWeight, int[] wts, int[] values, int start, int size) {
        int maxValue = 0;

        if (sackWeight == 0 || start == size) {
            return 0;
        }

//        int maxValue = 0; // You can also place maxValue here as well.
        for (int i = start; i < size; i++) {
            System.out.printf("Call loopNo [%s] for weight=[%s], start=[%s] and size=[%s] \n", i, sackWeight, i, size);
            if (wts[i] > sackWeight) {
                return findMaxProfitBruteForce2(sackWeight, wts, values, i + 1, size);

            } else {
                int tempValue = values[i] + findMaxProfitBruteForce2(sackWeight - wts[i], wts, values, i + 1, size);
                System.out.printf("Call returned to call for weight=[%s], start=[%s] and size=[%s] and current i=[%s], values[i] = [%s] and wt=[%s]\n", sackWeight, start, size, i, values[i], wts[i]);
                if (tempValue > maxValue) {
                    maxValue = tempValue;
                }
            }
        }
        return maxValue;
    }

    /**
     * This method find all possible subsets and works in O(2^n).
     * But this method uses recursive call within a loop.
     */
    static int tempValue = 0;
    public static int findMaxProfitBruteForce3(int sackWeight, int[] wts, int[] values, int start, int size, int maxValue) {
        if (sackWeight <= 0 || start == size) {
            return 0;
        }

        for (int i = start; i < size; i++) {

            if (wts[i] > sackWeight) {
                findMaxProfitBruteForce3(sackWeight, wts, values, i + 1, size, maxValue);

            } else {
                findMaxProfitBruteForce3(sackWeight - wts[i], wts, values, i + 1, size, maxValue + values[i]);
                if (tempValue < (maxValue + values[i])) {

                    tempValue = maxValue + values[i];
                }
            }
        }

        return tempValue;
    }

    /**
     * This algorithm works in O(given weights*total weight) time complexity and O(given weights*total weight) space complexity.
     */
    public static int findMaxProfitDP(int sackWeight, int[] wts, int[] values) {

        int[][] solTable = new int[wts.length][sackWeight + 1];

        for (int i = 0; i < sackWeight + 1; i++) {
            solTable[0][i] = i >= wts[0] ? values[0] : 0;
        }

        for (int i = 1; i < wts.length; i++) {
            for (int j = 0; j < sackWeight + 1; j++) {

                if (j < wts[i]) {
                    solTable[i][j] = solTable[i - 1][j];
                } else {
                    solTable[i][j] = Math.max(values[i] + solTable[i - 1][j - wts[i]], solTable[i - 1][j]);
                }
            }
        }
        System.out.println("The solution table is :::");
        for (int[] arr : solTable) {
            System.out.println(Arrays.toString(arr));
        }
        return solTable[wts.length - 1][sackWeight];
    }

    public static void main(String args[]) {
//        int val[] = new int[]{60, 100, 120, 10};
//        int wt[] = new int[]{10, 20, 30, 5};
//        int W = 55;
        int val[] = new int[]{10, 40, 30, 50};
        int wt[] = new int[]{5, 4, 6, 3};
        int W = 10;
        int n = val.length;

        System.out.println(findMaxProfitBruteForce(W, wt, val, n));
        System.out.println(findMaxProfitBruteForce2(W, wt, val, 0, n));
        System.out.println(findMaxProfitBruteForce3(W, wt, val, 0, n, 0));
        System.out.println(findMaxProfitDP(W, wt, val));
    }

}
