package com.datastructures.misc;

/* Decimal number to binary conversion */
public class DecimalToBinaryConversion {

    public static int[] decimalToBinaryConversion(int num) {
        int binaryRepresentation[] = new int[24];
        int index = 23;

        while (num != 0) {
            binaryRepresentation[index--] = num % 2;
            num = num / 2;
        }
        return binaryRepresentation;
    }

    public static void main(String[] args) {
        int binRep[] = decimalToBinaryConversion(25);
        System.out.println("The binary representation is : ");
        for (int i : binRep) {
            System.out.print(i);
        }
    }
}
