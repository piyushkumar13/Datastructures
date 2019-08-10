package com.datastructures.sorting;

/**
 * Merge sort time complexity is O(nlogn) and space complexity is O(n) for an extra array and O(logn) for the system stack
 * required for the recursive calls.So, total space complexity is O(n + logn) = O(n). But, it is stable sorting technique.
 * when operating on linked lists, mergesort only requires a small, constant amount of auxiliary storage.
 */
public class MergeSortExample {
    private static int[] helper;

    public MergeSortExample(int length) {
        helper = new int[length];
    }

    public static void mergeSort(int[] arr, int start, int last) {

        if (start < last) {
            int mid = start + (last - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, last);
            merge(arr, start, mid, last);

        }
    }

    public static void merge(int[] arr, int start, int mid, int last) {
        int n1 = mid - start + 1 ;
        int n2 = last - mid;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + i + 1];
        }

        int j = 0;
        int k = 0;
        int i = start;
        for (; j < n1 && k < n2; i++) {

            if (j < n1 && leftArray[j] <= rightArray[k]) {
                arr[i] = leftArray[j];
                j++;
            } else if (k < n2 && rightArray[k] < leftArray[j]) {
                arr[i] = rightArray[k];
                k++;
            }
        }

        while (j < n1){
            arr[i] = leftArray[j];
            i++;
            j++;
        }

        while (k < n2){
            arr[i] = rightArray[k];
            i++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 3, 7,5,6,4,8,2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Printing sorted array :::: ");
        for (int i : arr){
            System.out.print(i + "\t");
        }
    }
}
