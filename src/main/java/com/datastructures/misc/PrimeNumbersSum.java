package com.datastructures.misc;

/* Programme to find the sum of the first 1000 prime numbers. */
public class PrimeNumbersSum {

    private static boolean isPrimeNumber(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOf1000PrimeNumbers() {
        int count = 1;
        int num = 2;
        int sum = 0;

        while (count <= 1000) {
            if (isPrimeNumber(num)) {
                sum = sum + num;
                count++;
            }
            num++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("The sum of 1000 prime numbers is : " + sumOf1000PrimeNumbers());
    }
}
