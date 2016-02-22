package com.datastructures.sorting;

/**
 * It time complexity is O(n) and space complexity is O(n).
 * */
public class CountingSortExample {


    public static void countingSort(int[] arr, int maxValue) {

        int[] countArray = new int[maxValue + 1];
        int[] sortedArray = new int[arr.length + 1];

        for (int i : arr) {
            countArray[i] = countArray[i] + 1;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        for (int i = arr.length - 1; i > -1; i--) {

            sortedArray[countArray[arr[i]]] = arr[i];
            countArray[arr[i]] = countArray[arr[i]] - 1;
        }

        System.out.println("The sorted array is :::: ");
        /*This loop should be from i = 1 not i = 0 because count array gives the position of the element to be placed in
        the sorted array. And if element present in the arr, its position will never be 0 since 0 represent element is
        is not present.
        */
        for (int i = 1; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 5, 0, 2};
        countingSort(arr, 7);
    }

}
