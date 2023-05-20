package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 9/14/19.
 */
public class SubsetSumProblem {

    /**
     * This method finds all possible subsets and works in O(2^n).
     * This uses backtracking.
     *
     * @author Piyush Kumar.
     */
    static boolean isSubsetExistBruteForce(int[] arr, int aIndex, int size, int sum) {

        if (sum == 0) {
            return true;
        }
        if (aIndex == size) {
            return false;
        }

        for (int i = aIndex; i < size; i++) {
            if (arr[i] <= sum) {
                if (isSubsetExistBruteForce(arr, i + 1, size, sum - arr[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This method finds all possible subsets and works in O(2^n).
     * For more details refer this : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
     */
    static boolean isSubsetExistsBruteForce2(int[] arr, int size, int sum) {

        if (sum == 0) {
            return true;
        }

        if (size == 0 && sum != 0) {
            return false;
        }

        return isSubsetExistsBruteForce2(arr, size - 1, sum) || isSubsetExistsBruteForce2(arr, size - 1, sum - arr[size - 1]);
    }

    /**
     * This algorithm works in time complexity O(size*sum) and space complexity O(size*sum).
     */
    static boolean isSubsetExistsDPSol1(int[] arr, int sum) {

        int size = arr.length;
        boolean[][] solTable = new boolean[size][sum + 1];

        for (int i = 0; i < size; i++) {
            solTable[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            solTable[0][i] = arr[0] == i;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= sum; j++) {

                if (j >= arr[i]) {
                    solTable[i][j] = solTable[i - 1][j] || solTable[i - 1][j - arr[i]];
                } else {
                    solTable[i][j] = solTable[i - 1][j]; // Just copy whatever is there in above row. Consider given arr is {3,34,4} and sum = 7
                }
            }
        }

        for (boolean[] arr1 : solTable) {
            System.out.println(Arrays.toString(arr1));
        }

        return solTable[size - 1][sum];
    }

    /**
     * This algorithm works in time complexity O(size*sum) and space complexity O(sum).
     * This algorithm further optimizes the space complexity.
     */
    static boolean isSubsetExistsDPSol2(int[] arr, int sum) {
        boolean[] solTable = new boolean[sum + 1];

        solTable[0] = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= sum) {
                solTable[arr[i]] = true;
            }
        }

        int tempSum = 0;
        for (int i = 1; i < arr.length; i++) {
//            tempSum = tempSum + arr[i]; // Using tempSum as a condition for below loop. It signifies using current set of elements
//                                       // where I have iterated till now, how much total sum can be made.
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i]) {
                    solTable[j] = solTable[j] || solTable[j - arr[i]];
                }
            }
        }

        System.out.println(Arrays.toString(solTable));
        return solTable[sum];
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int size = arr.length;
        int sum = 10;

        if (isSubsetExistBruteForce(arr, 0, size, sum)) {
            System.out.println("The subset exists making given sum");
        } else {
            System.out.println("The subset does not exists making given sum");
        }

        boolean isSubsetExists = isSubsetExistsBruteForce2(arr, size, sum);
        if (isSubsetExists) {
            System.out.println("The subset exists by using bruteforce method 2");
        } else {
            System.out.println("The subset does not exists by using bruteforce method 2");
        }

        if (isSubsetExistsDPSol1(arr, sum)) {
            System.out.println("The subset exists by using DP method 1");

        } else {
            System.out.println("The subset does not exist by using DP method 1");
        }

        System.out.println(isSubsetExistsDPSol2(arr, sum));
    }
}
