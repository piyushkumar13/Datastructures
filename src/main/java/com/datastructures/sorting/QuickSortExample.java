package com.datastructures.sorting;

/**
 * Quick sort time complexity is O(nlogn) in best and average case. Quick sort average case is more lean to the best case,
 * instead of worst case. Its worst case time complexity is O(n^2) but this behaviour is very rare. Worst case in the quick sort
 * occurs when un-balanced partitioning happens. It means if an array is already sorted, then, it will result into the un-balanced
 * partitioning. Its space complexity is O(log n) in case of best case and average case and in worst case, it is O(n).
 * */
public class QuickSortExample {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int last) {
        int q;
        if (low < last) {
            q = partition(arr, low, last);
            quickSort(arr, low, q - 1);
            quickSort(arr, q + 1, last);
        }
    }

    public static int partition(int[] arr, int low, int last) {
        int pivot = arr[last];
        int j = low - 1;

        for (int i = low; i < last; i++) {
            if (arr[i] < pivot) {
                j = j + 1;
                swap(arr, i, j);
            }
        }
        swap(arr, j + 1, last);
        return (j + 1);
    }

    public static void main(String[] args) {
        int arr[] = {7, 3, 2, 1, 4, 9, 5, 8};

        quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is : ");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
