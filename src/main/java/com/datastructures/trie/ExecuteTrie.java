package com.datastructures.trie;

/**
 * @author Piyush Kumar.
 * @since 11/3/19.
 */
public class ExecuteTrie {

    public static void main(String[] args) {
        Trie root = new Trie();

        root.createTrie("Piyush");

        System.out.println("Searching [Piyush] ::::" + root.searchWord("Piyush"));

        System.out.println("Searching [Piyu] :::: " + root.searchWord("Piyu"));


    }

}


