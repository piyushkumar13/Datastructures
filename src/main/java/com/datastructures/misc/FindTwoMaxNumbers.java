package com.datastructures.misc;

/* Programme to find the two max numbers */
public class FindTwoMaxNumbers {

    public static void findTwoMaxNumbers(int[] arr) {
        int maxOne = 0;
        int maxTwo = 0;

        for (int i : arr) {
            if (i > maxOne) {
                maxOne = i;
            }
        }

        for (int i :arr){
            if (i < maxOne && i > maxTwo){
                maxTwo = i;
            }
        }

        System.out.println("The maximum number is : " + maxOne);
        System.out.println("The 2nd maximum number is : " + maxTwo);
    }

    public static void findTwoMaxNumbersAnotherWay(int[] arr){
            int maxOne = 0;
            int maxTwo = 0;

            for (int i : arr) {

                if (i > maxOne){
                    maxTwo = maxOne;
                    maxOne = i;
                }
                else if (i > maxTwo){
                    maxTwo = i;

                }
            }

            System.out.println("The maximum number is : " + maxOne);
            System.out.println("The 2nd maximum number is : " + maxTwo);

    }

    public static void main(String[] args) {

        int arr1[] = {1, 2, 8, 1, 10};
        findTwoMaxNumbers(arr1);

        int arr2[] = {0,8,2,4,2,5,6,7};
        findTwoMaxNumbersAnotherWay(arr2);
    }

}
