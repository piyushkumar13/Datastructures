package com.datastructures.sorting;

/**
 * Heap sort time complexity is O(nlogn) and space complexity is O(1). But, it is un-stable sort.
 */
public class HeapSortExample {

    public static void heapify(int[] arr, int index, int heapSize) {

        int l = getLeft(index);
        int r = getRight(index);
        int largest = index;

        if (l <= heapSize && arr[l] > arr[index]) {
            largest = l;
        }

        if (r <= heapSize && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != index) {
            swap(arr, index, largest);
            heapify(arr, largest, heapSize);
        }
    }

    public static void buildHeap(int arr[]) {
        int heapSize = arr.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length - 1;
        for (int i = heapSize; i >= 1; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, --heapSize);
        }

    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 8, 11, 3};

        System.out.println("Building heap ::::");
        buildHeap(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\nsorted array is ::: ");
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }

    private static int getLeft(int n) {
        return (2 * n + 1);
    }

    private static int getRight(int n) {
        return (2 * n + 2);
    }

    private static void swap(int[] arr, int index, int largest) {
        int temp;
        temp = arr[index];
        arr[index] = arr[largest];
        arr[largest] = temp;
    }

}
