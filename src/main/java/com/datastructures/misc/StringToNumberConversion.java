package com.datastructures.misc;

/*
* Programme to convert the string to a number without using Integer.parseIn() or any conversion function.
* */
public class StringToNumberConversion {

    public static int convertStringToNumber(String num) {

        char[] numChar = num.toCharArray();
        char zeroAscii = '0';
        int number = 0;

        for (char c : numChar) {
            int charAscii = (int) c;
            number = number * 10 + (charAscii - zeroAscii);
        }
        return number;
    }

    public static void main(String[] args) {
        int number = convertStringToNumber("31432");
        System.out.println("The number is : " + number);
    }

}
