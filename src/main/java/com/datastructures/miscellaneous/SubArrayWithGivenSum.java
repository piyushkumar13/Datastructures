/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Piyush Kumar.
 * @since 04/09/22.
 */
public class SubArrayWithGivenSum {


    /*
     * Complete the 'countNumberOfSubarrays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

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
}


class Result {

    /*
     * Complete the 'countNumberOfSubarrays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static long countNumberOfSubarrays(List<Integer> arr, int k) {

        LinkedList<Integer> queue = new LinkedList<>();

        int i = 0;
        int queueSum = 0;
        int count = 0;

        while (i < arr.size()) {

            if (arr.get(i) > k && queue.isEmpty()) {
                i++;
            } else if (arr.get(i) > k && !queue.isEmpty()) {
                queueSum = queueSum - queue.removeFirst();

                if (queueSum == k) {
                    count++;
                }
            } else if (arr.get(i) <= k && queueSum > k) {
                queueSum = queueSum - queue.removeFirst();
                if (queueSum == k) {
                    count++;
                }
            } else if (arr.get(i) <= k && queueSum <= k) {
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

        String a = "\"abc\"";
        String[] str = a.split("\"");

        for (String ab : str) {
            System.out.println(a);
        }

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(-2);
        list.add(-20);
        list.add(10);
        list.add(-10);
        System.out.println(countNumberOfSubarrays(list, 5));
    }

}

