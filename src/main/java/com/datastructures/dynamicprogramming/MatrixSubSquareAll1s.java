package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 11/9/19.
 */
public class MatrixSubSquareAll1s {


    public static int[][] getSubSquareAll1s(int[][] matrix) {

        /* Assuming its not a jagged 2-D array*/
        int[][] solTable = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    solTable[i + 1][j + 1] = Math.min(solTable[i][j], Math.min(solTable[i][j + 1], solTable[i + 1][j])) + 1;
                }
            }
        }

        for (int[] arr : solTable) {
            System.out.println(Arrays.toString(arr));
        }

        return solTable;
    }

    public static void main(String[] args) {
        int M[][] = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[][] solTable = getSubSquareAll1s(M);

        /* Finding the max entry in the solution table. */
        int maxEntry = Integer.MIN_VALUE;

        for (int i=0; i < solTable.length; i++){
            for (int j=0; j < solTable[0].length; j++){
                if (solTable[i][j] > maxEntry){
                    maxEntry = solTable[i][j];
                }
            }
        }



        System.out.println("The maximum size of a matrix with all 1s are ::: " + maxEntry);
    }
}
