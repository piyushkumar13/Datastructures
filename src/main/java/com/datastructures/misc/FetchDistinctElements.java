package com.datastructures.misc;

/* Programme to find the distinct elements in the array. */
public class FetchDistinctElements {

    public static void fetchDistinctElements(int[] arr) {
        boolean isDuplicate;
        System.out.println("The distinct elements in the array are : ");

        for (int i = 0; i < arr.length; i++) {
            isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 2, 44, 1, 5, 6, 3, 1, 4, 3, 5, 3, 2, 4};
        fetchDistinctElements(arr);
    }
}
