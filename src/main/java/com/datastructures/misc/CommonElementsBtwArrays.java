package com.datastructures.misc;

/* Programme to get the common elements */
public class CommonElementsBtwArrays {

    /* Time complexity is  O(n^2) */
    public static void commonElementsBtwTwoArrays(int arr1[], int arr2[]) {

        for (int i : arr1) {
            for (int j : arr2) {
                if (i == j) {
                    System.out.println(i);
                }
            }
        }
    }

    /* Time complexity is O(n) but space complexity is O(n) for the extra array.And here, we need to have assumption that
     * all the elements in the two are in the range of n */
    public static void commonElementsBtwTwoArraysOptimized(int arr1[], int[] arr2) {
        int[] countArr = new int[10];

        for (int i : arr1) {
            countArr[i] = countArr[i] + 1;
        }

        for (int i : arr2) {
            countArr[i] = countArr[i] + 1;
        }
        for (int j = 0; j < countArr.length; j++) {
            if (countArr[j] > 1) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {2, 1, 8, 3, 6};
        int arr2[] = {4, 3, 6, 1, 7};
        commonElementsBtwTwoArrays(arr1, arr2);
        commonElementsBtwTwoArraysOptimized(arr1, arr2);
    }

}
