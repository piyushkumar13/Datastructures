package com.datastructures.dynamicprogramming;

import java.util.Arrays;

/**
 * @author Piyush Kumar.
 * @since 11/3/19.
 */
public class EggDroppingProblem {

    /**
     * This method find all possible subsets and works in exponential time complexity.
     * For details you can refer following links :
     * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
     * https://www.youtube.com/watch?v=KVfxgpI3Tv0&t=750s
     * https://www.youtube.com/watch?v=amdKmQlATmQ&t=597s
     * https://www.youtube.com/watch?v=iOaRjDT0vjc
     * https://www.youtube.com/watch?v=3hcaVyX00_4&t=316s
     * https://algorithms.tutorialhorizon.com/dynamic-programming-egg-dropping-problem/
     *
     */
    public static int getMinAttemptsBruteForce(int eggs, int floors){

        if (floors == 1 || floors == 0){
            return floors;
        }

        if (eggs == 1){
            return floors;
        }

        int minAttempts = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++){

            int tempRes = Math.max(getMinAttemptsBruteForce(eggs-1, i - 1),
                    getMinAttemptsBruteForce(eggs, floors-i));

            if (tempRes < minAttempts){

                minAttempts = tempRes;
            }
        }

        return minAttempts + 1;
    }

    public static int getMinAttemptsDPSol(int eggs, int floors){
        int[][] solTable = new int[eggs + 1][floors+1];

        for (int i = 0; i <= eggs; i++){
            solTable[i][0]= 0;
        }

        for (int i = 0; i <= floors; i++){
            solTable[0][i] = 0;
            solTable[1][i] = i;
        }



        for (int i = 2; i <= eggs; i++){

            for (int j = 1; j <= floors; j++){

                solTable[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <=j; x++){
                    int tempRes  = 1 + Math.max(solTable[i-1][x-1], solTable[i][j-x]);

                    if (tempRes < solTable[i][j]){
                        solTable[i][j] = tempRes;
                    }
                }
            }
        }

        for (int[] arr : solTable){
            System.out.println(Arrays.toString(arr));
        }
        return solTable[eggs][floors];

    }


    public static void main(String[] args) {
        int minAttempts = getMinAttemptsBruteForce(2, 10);

        System.out.println("The minimum attempts are :::: " + minAttempts);

        System.out.println("The minimum attempts using dp solution :::: " + getMinAttemptsDPSol(2, 10));
    }
}
