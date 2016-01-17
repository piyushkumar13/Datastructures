package com.datastructures.misc;

/* Programme to covert binary to decimal. */
public class BinaryToDecimal {

    public static int binaryToDecimal(int[] binaryArr) {
        int sum = 0;
        int i = binaryArr.length - 1;
        int j = 0;

        while (i >= 0) {
            sum = sum + binaryArr[i] * (int) Math.pow(2, j);
            i--;
            j++;
        }
        return sum;
    }

    public static int binaryToDecimal(int binaryValue) {
        int temp;
        int sum = 0;
        int i = 0;

        while (binaryValue != 0) {
            temp = binaryValue % 10;
            sum += temp * (int)Math.pow(2, i);
            binaryValue = binaryValue / 10;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[24];
        arr[23] = 1;
        arr[22] = 0;
        arr[21] = 1;

        System.out.println("The value of binary in decimal is : " + binaryToDecimal(arr));
        System.out.println("The value of binary in decimal is : "+ binaryToDecimal(1101));
    }
}
