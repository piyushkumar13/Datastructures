/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.miscellaneous;

/**
 * @author Piyush Kumar.
 * @since 31/08/22.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArrWithGivenSum {


    public static long countNumberOfSubarrays(List<Integer> arr, int k) {

        LinkedList<Integer> queue = new LinkedList<>();

        int i = 0;
        int queueSum = 0;
        int count = 0;
        while (i < arr.size()) {

            if (queueSum > k) {
                queueSum = queueSum - queue.removeFirst();
                if (queueSum == k) {
                    count++;
                }
            } else {

                queue.add(arr.get(i));
                queueSum = queueSum + arr.get(i);
                if (queueSum == k) {
                    count++;
                }
                i++;
            }
        }

        while (!queue.isEmpty()) {
            queueSum = queueSum - queue.removeFirst();
            if (queueSum == k) {
                count++;
            }
        }


        return count;


    }


    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(2);
        arr.add(-2);
        arr.add(-20);
        arr.add(10);
        arr.add(-10);
        long l = countNumberOfSubarrays(arr, 5);
        System.out.println(l);
    }

}