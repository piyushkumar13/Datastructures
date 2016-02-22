package com.datastructures.sorting;

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
