package com.datastructures.misc;

import java.util.StringTokenizer;

public class StringReversing {


    public static String reverseString(String str) {
        String temp = "";
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        while (tokenizer.hasMoreTokens()) {
            temp = tokenizer.nextToken() + " " + temp;
        }
        return temp;
    }

    public static String reverseStringUsingSplit(String str) {
        String[] temp = str.split(" ");
        String reverseString = "";

        for (String temp2 : temp) {
            reverseString = temp2 + " " + reverseString;
        }
        return reverseString;
    }

    public static String reverseStringMoreManualWay(String str) {
        int i = 0;
        int j = 0;

        char arr[] = str.toCharArray();
        while (i < arr.length) {

            if (arr[i] == ' ') {
                reverse(j, i-1, arr);
                j = i + 1;
            }
            i++;
        }
        reverse(j,i-1,arr);
        reverse(0, i-1, arr);
        return String.valueOf(arr);
    }

    private static void reverse(int j, int i, char arr[]) {

        while (j<i){
            char temp = arr[j]  ;
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
            i--;
        }
    }

    public static String reverseWordThroughRecursion(String str){

        String reverse = "";

        if (str.length() == 1){
            return str;
        }
        else {
            reverse += str.charAt(str.length()-1) + reverseWordThroughRecursion(str.substring(0, str.length() - 1));
        }

        return reverse;

    }

    public static void main(String[] args) {

        System.out.println(reverseString("This is my world of programming"));
        System.out.println(reverseStringUsingSplit("Programming is fun"));
        System.out.println(reverseStringMoreManualWay("I love programming"));
        System.out.println(reverseWordThroughRecursion("Piyush"));
    }
}
