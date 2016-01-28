package com.datastructures.misc;


/* Programme to find out the middle index where the sum of both ends are equal. */
public class FindMiddleIndex {

    public static int findMiddleIndex(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int sumLeft = 0;
        int sumRight = 0;

        while (true) {

            if (sumLeft < sumRight) {
                sumLeft += sumLeft + arr[startIndex++];

            } else if (sumRight <= sumLeft && startIndex != endIndex) {
                sumRight += sumRight + arr[endIndex--];

            } else if (startIndex == endIndex && sumLeft == sumRight) {
                return endIndex;

            } else {
                throw new RuntimeException("The index does not exist where all the elements sum to its left is equal" +
                        "to the sum of the elements to its right");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        int middleIndex = findMiddleIndex(arr);
        System.out.println("The middle index is " + middleIndex);
    }
}
