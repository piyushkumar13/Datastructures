package com.datastructures.sorting;

/**
 * Insertion sort is preferred for the smaller inputs over the merge sort or any other sorting algorithm even though the
 * time complexity of insertion sort is O(n^2) because the coefficients that are hidden in the big-oh notation is smaller
 * than the merge sort constants. Hence, insertion sort performs well for the smaller inputs.
 * <p/>
 * Insertion sort and bubble sort both have the O(n) in their best case still insertion sort performs better than the
 * bubble sort because of the lower constants in big-oh notation. Bubble sort is only useful to detect whether the given
 * list is already sorted or not. But, practically bubble sort is not at all preferred.
 */
public class InsertionSortExample {

    public static int[] insertionSort(int[] arr) {
        int key;

        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 6, 2, 7, 3, 9, 5, 8};
        int sortedArr[] = insertionSort(arr);

        for (int i : sortedArr) {
            System.out.print(i);
        }
    }

}
