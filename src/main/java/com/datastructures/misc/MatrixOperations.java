package com.datastructures.misc;

public class MatrixOperations {

    public static void createMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + j;
            }
        }
    }

    public static void transposeMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = arr[j][i];
            }
        }
    }

    public static void addMatrices(int[][] arr1, int[][] arr2, int[][] addedArray) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                addedArray[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
    }

    public static void malMatrices(int[][] arr1, int[][] arr2, int[][] malArray) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                malArray[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    malArray[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }


    }

    public static void printMatrix(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[3][3];
        int[][] arr2 = new int[3][3];
        int[][] addedArray = new int[3][3];
        int[][] malArray = new int [3][3];

        createMatrix(arr1);
        System.out.println("Printing the matrix 1 ");
        printMatrix(arr1);

        transposeMatrix(arr1);
        System.out.println("Printing the transposed matrix 1 ");
        printMatrix(arr1);

        createMatrix(arr2);
        System.out.println("Printing the matrix 2");
        printMatrix(arr2);

        addMatrices(arr1, arr2, addedArray);
        System.out.println("Printing the added matrix");
        printMatrix(addedArray);

        malMatrices(arr1,arr2,malArray);
        System.out.println("Printing multiplied matrix");
        printMatrix(malArray);



    }

}
