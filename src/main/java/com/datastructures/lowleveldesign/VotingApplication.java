/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.lowleveldesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Piyush Kumar.
 * @since 30/03/23.
 */
public class VotingApplication {

    private static int[] simpleMap = new int[]{3, 2, 1};

    public static String getWinner(String[] votes) {

        Map<Character, Integer> scoreMap = new HashMap<>();

        int length = votes[0].length();

        for (String vote : votes) {

            for (int i = 0; i < length; i++) {

                Character key = vote.charAt(i);

                if(scoreMap.containsKey(key)){
                    int presentScore = scoreMap.get(key);
                    scoreMap.put(key, presentScore + simpleMap[i]);
                }else{
                    scoreMap.put(key, simpleMap[i]);
                }
            }
        }

        List<Character> keySet = new ArrayList<>(scoreMap.keySet());

        Collections.sort(keySet, (a, b) -> {

            if (scoreMap.get(b) != scoreMap.get(a)){
                return scoreMap.get(b) - scoreMap.get(a);
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (Character key : keySet){
            sb.append(key);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String winner = getWinner(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});
        System.out.println(winner);
    }

}
