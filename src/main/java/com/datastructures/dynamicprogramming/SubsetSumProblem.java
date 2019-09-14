package com.datastructures.dynamicprogramming;

/**
 * @author Piyush Kumar.
 * @since 9/14/19.
 */
public class SubsetSumProblem {

    /**
     * This algorithm works in O(2^n) as it finds all possible subsets. This uses backtracking.
     */
    static boolean isSubsetExist1(int[] arr, int aIndex, int size, int sum) {

        if (sum == 0) {
            return true;
        }
        if (aIndex == size) {
            return false;
        }

        for (int i = aIndex; i < size; i++) {
            if (arr[i] <= sum) {
                if (isSubsetExist1(arr, i + 1, size, sum - arr[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * This method also find all possible subsets and works in O(2^n).
     * For more details refer this : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
     */
    static boolean isSubsetExists2(int[] arr, int size, int sum) {

        if (sum == 0) {
            return true;
        }

        if (size < 0 && sum != 0) {
            return false;
        }

        return isSubsetExists2(arr, size - 1, sum) || isSubsetExists2(arr, size - 1, sum - arr[size]);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 34};
        int size = arr.length;
        int sum = 34;

        if (isSubsetExist1(arr, 0, size, sum)) {
            System.out.println("The subset exists making given sum");
        } else {
            System.out.println("The subset does not exists making given sum");
        }

        int size2 = size - 1;

        boolean isSubsetExists = isSubsetExists2(arr, size2, sum);
        if (isSubsetExists) {
            System.out.println("The subset exits by using bruteforce method 2");
        } else {
            System.out.println("The subset does not exits by using bruteforce method 2");
        }
    }
}
