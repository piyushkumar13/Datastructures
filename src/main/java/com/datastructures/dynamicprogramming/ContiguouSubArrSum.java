package com.datastructures.dynamicprogramming;

/**
 * @author Piyush Kumar.
 * @since 9/29/19.
 */
public class ContiguouSubArrSum {

    /**
     * Its bruteforce approach will work in O(n^3) by using 3 loops.
     * For more details refer your videos.
     */

    /**
     * This algorithm works in time complexity O(n) and with constant space complexity O(1).
     */
    public static int findMaxSubArrSum(int[] arr) {
        int previousSum = arr[0];
        int maxSum = 0;

        for (int i = 1; i < arr.length; i++) {

            previousSum = Math.max(arr[i] + previousSum, arr[i]) < 0 ? 0 : Math.max(arr[i] + previousSum, arr[i]);
            if (previousSum > maxSum) {
                maxSum = previousSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        int[] arr = {-4, 15, -6, 18, 2, -20}; // results : 29
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -2}; // results : 7

        int maxSum = findMaxSubArrSum(arr);
        System.out.println("The contiguous max sub array sum is ::: " + maxSum);
    }

}
