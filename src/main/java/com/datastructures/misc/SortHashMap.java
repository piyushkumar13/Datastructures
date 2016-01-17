package com.datastructures.misc;

import java.util.*;

/* Programme to sort the HashMap by value */
public class SortHashMap {

    public static List<Map.Entry<String, Integer>> sortHashMap(Map<String, Integer> mapValue) {

        Set<Map.Entry<String, Integer>> entries = mapValue.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entries);

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Map<String, Integer> mapValue = new HashMap<String, Integer>();
        mapValue.put("Piyush", 13);
        mapValue.put("Sheel", 7);
        mapValue.put("Brijesh", 21);
        mapValue.put("Shree ram", 2);
        mapValue.put("Apuroop", 18);
        mapValue.put("Vikas", 1);

        List<Map.Entry<String, Integer>> list = sortHashMap(mapValue);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }
}
