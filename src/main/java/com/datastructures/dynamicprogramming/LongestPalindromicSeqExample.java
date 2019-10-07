package com.datastructures.dynamicprogramming;

/**
 * @author Piyush Kumar.
 * @since 10/8/19.
 */
public class LongestPalindromicSeqExample {


    public static int findLongestPalindromicSeqBruteForce(char[] arr, int start, int end) {

        if (start == end) {
            return 1;
        } else if (start + 1 == end && arr[start] == arr[end]) {
            return 2;
        } else if (start + 1 == end && arr[start] != arr[end]) {
            return 1;
        } else if (arr[start] == arr[end]) {
            return 2 + findLongestPalindromicSeqBruteForce(arr, start + 1, end - 1);
        } else {
            return Math.max(findLongestPalindromicSeqBruteForce(arr, start + 1, end), findLongestPalindromicSeqBruteForce(arr, start, end - 1));
        }
    }

    public static int findLongestPalindromicSeqDPSol(char[] arr) {

        int[][] solTable = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            solTable[i][i] = 1;
        }

        for (int charLen = 2; charLen <= arr.length; charLen++) {

            for (int i = 0; i < arr.length - charLen + 1; i++) {
                int j = i + charLen - 1;

                if (arr[i] == arr[j]) {
                    solTable[i][j] = 2 + solTable[i + 1][j - 1];
                } else {
                    solTable[i][j] = Math.max(solTable[i + 1][j], solTable[i][j - 1]);
                }
            }
        }

        return solTable[0][arr.length - 1];
    }


    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
//        String seq = "BABCBAB";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d \n", findLongestPalindromicSeqBruteForce(seq.toCharArray(), 0, n - 1));
        System.out.printf("The length of the LPS using DP solution is %d \n", findLongestPalindromicSeqDPSol(seq.toCharArray()));

    }

}
