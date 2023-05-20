package com.datastructures.misc;


/**
 * Merging two sorted arrays.
 */
public class MergeTwoArrays {

    public static int[] mergeArrays(int[] a, int[] b) {
        int lengthMergedArray = a.length + b.length;
        int[] mergedArray = new int[lengthMergedArray];

        int j = 0;
        int k = 0;
        int i;
        for (i = 0; i < lengthMergedArray; i++) {

            if (a[j] < b[k]) {
                mergedArray[i] = a[j];
                j++;
                if (j >= a.length) {
                    while (k < b.length) {
                        i++;
                        mergedArray[i] = b[k];
                        k++;
                    }
                }

            } else {
                mergedArray[i] = b[k];
                k++;
                if (k >= b.length) {
                    while (j < a.length) {
                        i++;
                        mergedArray[i] = a[j];
                        j++;
                    }
                }
            }
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 9};
        int[] b = {3, 6,};

        int[] mergedArray = mergeArrays(a, b);
        for (int i : mergedArray) {
            System.out.println(i + "\t");
        }

    }

}
