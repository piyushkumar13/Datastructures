package com.datastructures.sorting;

import java.util.Arrays;

public class HeapOperations {

    /**
     * I am maintaining the heap size as a global variable to share the heap size among different operations of the heap.
     */
    private static int heapSize;

    private static int getParent(int n) {
        return (n - 1) / 2;
    }

    public static int heapMaximum(int[] heap) {

        return heap[0];
    }

    public static int extractMaximum(int[] heap) {

        heapSize = heap.length - 1;

        if (heap.length < 1) {
            throw new RuntimeException("Heap under flows.");
        }

        int max = heap[0];
        heap[0] = heap[heapSize];
        heapSize = heapSize - 1;
        HeapSortExample.heapify(heap, 0, heapSize);
        return max;
    }

    public static void increaseKey(int[] heap, int index, int key) {

        if (key < heap[index]) {
            throw new RuntimeException("Key is smaller than the current key value.");
        }

        heap[index] = key;
        int temp;
        while (index > 0 && heap[getParent(index)] < key) {
            temp = heap[getParent(index)];
            heap[getParent(index)] = key;
            heap[index] = temp;
            index = getParent(index);
        }
    }

    public static int[] insertKey(int[] heap, int key) {

        int [] newArr = Arrays.copyOf(heap, heap.length + 1);
        heapSize = heapSize + 1;
        newArr[heapSize] = Integer.MIN_VALUE;
        increaseKey(newArr, heapSize, key);
        return newArr;
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 6, 7, 2, 3};
        heapSize = arr.length - 1;

        HeapSortExample.buildHeap(arr);
        System.out.println("The built heap is ::: ");
        for (int i = 0; i <= heapSize; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n");

        System.out.println("Heap maximum is : " + heapMaximum(arr));

        System.out.println("Extracting maximum in the array : " + extractMaximum(arr));
        System.out.println("The heap after extracting maximum is ::: ");
        for (int i = 0; i <= heapSize; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\n");
        System.out.printf("Increasing key at index %d .\n", 4);
        increaseKey(arr, 4, 10);
        System.out.println("Heap after increasing the key is : ");
        for (int i = 0; i <= heapSize; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\nInserting key in the heap :::");
        int[] newHeap = insertKey(arr, 5);
        for (int i = 0; i <= heapSize; i++) {
            System.out.print(newHeap[i] + "\t");
        }
    }
}
