package com.datastructures.misc;

public class FindMaxAndMin {

    public static int findMax(int[] arr) {

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        return min;
    }

    /**
     * This is the optimized way of finding the min and maximum. Its time complexity is O(n/2).
     * It performs 3n/2 comparisons. This method is for the array having odd parity.
    * */
    public static void findMaxAndMin(int[] arr) {

        int size = arr.length - 1;
        int max = arr[0];
        int min = arr[1];

        for (int i = 1; i < size; i = i + 2) {

            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        System.out.println("The maximum number in the array is : " + max);
        System.out.println("The minimum number in the array is : " + min);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 7, 1, 8, 9};
        System.out.println("The maximum element in the array is : " + findMax(arr));
        System.out.println("The minimum element in the array is : " + findMin(arr));
        findMaxAndMin(arr);
    }
}
