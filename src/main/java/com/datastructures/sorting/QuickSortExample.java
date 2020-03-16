package com.datastructures.sorting;

/**
 * Quick sort time complexity is O(nlogn) in best and average case. Quick sort average case is more lean to the best case,
 * instead of worst case. Its worst case time complexity is O(n^2) but this behaviour is very rare. Worst case in the quick sort
 * occurs when un-balanced partitioning happens. It means if an array is already sorted, then, it will result into the un-balanced
 * partitioning. Its space complexity is O(log n) in case of best case and average case and in worst case, it is O(n).
 */
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

//    /**
//     * This is Hoare's algorithm.
//     * Uncomment to use it.
//     */
//    public static int partition(int[] arr, int low, int high) {
//        int pivot = arr[low];
//        int i = low - 1;
//        int j = high + 1;
//
//        while (true) {
//            do {
//                i++;
//            } while (arr[i] < pivot);
//
//            do {
//                j--;
//            } while (arr[j] > pivot);
//
//            if (i >= j)
//                return i;
//            swap(arr, i, j);
//        }
//    }

//    /**
//     * This is Hoare's algorithm modified by
//     *
//     * @author Piyush Kumar
//     * Uncomment to use it.
//     */
//    public static int partition(int[] arr, int low, int high) {
//        int pivot = arr[low];
//        int i = low;
//        int j = high;
//
//        while (true) {
//            while (arr[i] < pivot) {
//                i++;
//            }
//
//            while (arr[j] > pivot) {
//                j--;
//            }
//
//            if (i >= j) {
//                return i;
//            } else {
//                swap(arr, i, j);
//                i++;
//                j--;
//            }
//        }
//    }


    public static void main(String[] args) {
        int arr[] = {7, 3, 2, 1, 4, 9, 5, 8};

        quickSort(arr, 0, arr.length - 1);
        System.out.println("The sorted array is : ");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
