package com.datastructures.misc;

import java.util.Scanner;

/**
 * A matrix is given having only 1s followed by 0s. Find the row with the maximum number of 1s.
 */
public class MatrixRowWithMax1 {

    private static int last(int arr[], int low, int high) {
        if (high >= low) {
            // get the middle index
            int mid = low + (high - low) / 2;

            // check if the element at middle index is first 1
            if ((mid == 0 || arr[mid + 1] == 0) && arr[mid] == 1)
                return mid;

                // if the element is 0, recur for left side
            else if (arr[mid] == 0)
                return last(arr, low, (mid - 1));

            else // If element is not first 1, recur for right side
                return last(arr, mid + 1, high);
        }
        return -1;
    }


    private static int maxOnes(int mat[][]) {
        int max_row_index = 0, max = -1; // Initialize max values

        // Traverse for each row and count number of 1s by finding the index
        // of first 1
        int i, index;
        for (i = 0; i < mat.length; i++) {
            index = last(mat[i], 0, (mat[i].length - 1));
            if (index != -1 && (index + 1) > max) {
                max = index;
                max_row_index = i;
            }
        }

        return max_row_index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The length of the row ");
        int row = scanner.nextInt();
        System.out.println("The length of the column");
        int column = scanner.nextInt();

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }

        int index = maxOnes(matrix);

        System.out.println("The row having max 1");
        System.out.println(index);

    }

}
