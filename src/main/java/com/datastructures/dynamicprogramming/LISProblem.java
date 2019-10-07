package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 9/28/19.
 */
public class LISProblem {


    /**
     * This algorithm will work in O(2^n). This algorithm goes from start to end.
     */
    public static int lisBruteForce(int[] arr, int i, int n, int prev) {

        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }

        // case 1: exclude the current element and process the
        // remaining elements
        int excl = lisBruteForce(arr, i + 1, n, prev);

        // case 2: include the current element if it is greater
        // than previous element in LIS
        int incl = 0;
        if (arr[i] > prev) {
            incl = 1 + lisBruteForce(arr, i + 1, n, arr[i]);
        }

        // return maximum of above two choices
        return Math.max(incl, excl);
    }

    /**
     * This algorithm will work in O(2^n). This algorithm goes from end to start.
     */
    public static int lisBruteForce2(int[] arr, int n, int next) {

        // Base case: nothing is remaining
        if (n == 0) {
            return 0;
        }

        // case 1: exclude the current element and process the
        // remaining elements
        int excl = lisBruteForce2(arr, n - 1, next);

        // case 2: include the current element if it is greater
        // than previous element in LIS
        int incl = 0;
        if (arr[n - 1] < next) {
            incl = 1 + lisBruteForce2(arr, n - 1, arr[n - 1]);
        }

        // return maximum of above two choices
        return Math.max(incl, excl);
    }

    /**
     * This will run in time complexity O(n) with space complexity O(n)
     */
    public static int listWithDP(int[] arr) {

        int size = arr.length;
        int[] lisArr = new int[size];

        Arrays.fill(lisArr, 1);

        for (int i = 1; i < arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (temp < lisArr[i] + lisArr[j]) {
                        temp = lisArr[i] + lisArr[j];
                    }
                }
            }

            lisArr[i] = temp;
        }

        System.out.println(Arrays.toString(lisArr));
        return lisArr[lisArr.length - 1];
    }


    public static void main(String[] args) {
        int[] arr = {3, 2,10, 12};

        int lisLen = lisBruteForce(arr, 0, arr.length, Integer.MIN_VALUE);

        System.out.println("The longest increasing length is :::: " + lisLen);

        int lisLen2 = lisBruteForce2(arr, arr.length, Integer.MAX_VALUE);
        System.out.println("The longest increasing length is :::: " + lisLen2);

        int lisLen3 = listWithDP(arr);
        System.out.println("The longest increasing length is :::: " + lisLen3);

    }
}
