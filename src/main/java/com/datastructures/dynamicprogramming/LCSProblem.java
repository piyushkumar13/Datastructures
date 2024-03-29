package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 10/7/19.
 */
public class LCSProblem {


    /**
     * This method find all possible subsets and works in O(2^n).
     * For more details refer this : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
     */
    public static int findLCSBruteForce(char[] str1, char[] str2, int lenStr1, int lenStr2) {

        if (lenStr1 == 0 || lenStr2 == 0) {
            return 0;
        } else if (str1[lenStr1 - 1] == str2[lenStr2 - 1]) {
            return 1 + findLCSBruteForce(str1, str2, lenStr1 - 1, lenStr2 - 1);
        } else {
            return Math.max(findLCSBruteForce(str1, str2, lenStr1 - 1, lenStr2), findLCSBruteForce(str1, str2, lenStr1, lenStr2 - 1));
        }
    }

    /**
     * This algorithm works in time complexity O(str1*str2Len) and space complexity O(str1*str2Len).
     */
    public static int findLCSDPSol(char[] str1, char[] str2) {
        int[][] solTable = new int[str1.length][str2.length];

        for (int i = 0; i < str1.length; i++) {
            if (str2[0] == str1[i]) {
                solTable[0][i] = 1;
            }
        }

        for (int i = 0; i < str1.length; i++) {
            if (str1[0] == str2[i]) {
                solTable[i][0] = 1;
            }
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {

                if (str1[i] == str2[j]) {
                    solTable[i][j] = 1 + solTable[i - 1][j - 1];
                } else {
                    solTable[i][j] = Math.max(solTable[i - 1][j], solTable[i][j - 1]);
                }
            }
        }

        for (int[] arr : solTable) {
            System.out.println(Arrays.toString(arr));
        }
        return solTable[str1.length - 1][str2.length - 1];

    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("The longest sequence length is ::: " + findLCSBruteForce(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println("The longest sequence length using DP sol is ::: " + findLCSDPSol(s1.toCharArray(), s2.toCharArray()));
    }


}
