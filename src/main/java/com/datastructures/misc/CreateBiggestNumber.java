package com.datastructures.misc;


import java.util.Arrays;
import java.util.Comparator;

public class CreateBiggestNumber {


    public static String[] createNumber(String[] arr) {

        Arrays.sort(arr, new Comparator<String>() {


            @Override
            public int compare(String o1, String o2) {

                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;

                return o2o1.compareTo(o1o2);
            }
        });
        return arr;

    }


    public static void main(String[] args) {
        String[] arr = {"5", "2", "7", "4", "78", "3"};

        String[] a = createNumber(arr);
        for (String a2 : a) {
            System.out.print(a2);
        }

    }

}

