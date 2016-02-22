package com.datastructures.sorting;

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

//    public static void merge(int[] arr, int start, int mid, int last) {
//        int n1 = mid - start ;
//        int n2 = last - mid;
//        int leftArray[] = new int[n1+1];
//        int rightArray[] = new int[n2];
//
//        for (int i = 0; i <= n1; i++) {
//            leftArray[i] = arr[start + i];
//            i++;
//        }
//
//        for (int i = 0; i <= n2; i++) {
//            rightArray[i] = arr[mid + i + 1];
//            i++;
//        }
//
//        int j = 0;
//        int k = 0;
//        for (int i = 0; i <= last; i++) {
//
//            if (j < n1 && leftArray[j] <= rightArray[k]) {
//                arr[i] = leftArray[j];
//                j++;
//            } else if (k < n2 && rightArray[k] < leftArray[j]) {
//                arr[i] = rightArray[k];
//                k++;
//            }
//        }
//    }

    public static void merge(int[] arr, int low, int mid, int last) {

        int i = low;
        int j = mid + 1;
        int l = 0;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j]) {
                helper[l] = arr[low];
                i++;
                l++;

            } else {
                helper[l] = arr[j];
                j++;
                l++;
            }
        }

        if (i < mid) {
            while (i <= mid) {
                helper[l] = arr[i];
                i++;
                l++;
            }
        }

        if (j < last) {
            while (j <= last) {
                helper[l] = arr[j];
                j++;
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 9};
        MergeSortExample sortExample = new MergeSortExample(arr.length);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Printing sorted array :::: ");
        for (int i : helper) {
            System.out.print(i);
        }
    }
}
