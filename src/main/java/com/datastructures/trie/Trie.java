package com.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Kumar.
 * @since 11/2/19.
 * <p>
 * Refer this video : https://www.youtube.com/watch?v=AXjmTQ8LEoI
 * <p>
 * and his github link : https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
 */
public class Trie {

    private TrieNode root;

    private class TrieNode {

        private Map<Character, TrieNode> dataMap;
        private boolean isEndOfWord;

        TrieNode() {
            this.dataMap = new HashMap<Character, TrieNode>();
            this.isEndOfWord = false;
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void createTrie(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            TrieNode tempNode = currentNode.dataMap.get(ch);

            if (tempNode == null) {
                tempNode = new TrieNode();
                currentNode.dataMap.put(ch, tempNode);
            }

            currentNode = tempNode;
        }

        currentNode.isEndOfWord = true;
    }

    public void createTrieRecursively(String word) {

        createRecursively(word, root, 0);
    }

    private void createRecursively(String word, TrieNode current, int index) {
        if (index == word.length()) {
            current.isEndOfWord = true;
            return;
        }

        TrieNode tempNode = current.dataMap.get(word.charAt(index));
        if (tempNode == null) {
            tempNode = new TrieNode();
            current.dataMap.put(word.charAt(index), tempNode);
        }

        current = tempNode;

        createRecursively(word, current, index + 1);
    }


    public boolean searchWord(String word) {

        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode tempNode = current.dataMap.get(word.charAt(i));

            if (tempNode == null) {
                return false;
            }

            current = tempNode;
        }

        return current.isEndOfWord;
    }

    public boolean searchWordRecursively(String word) {

        return searchRecursively(word, root, 0);

    }

    private boolean searchRecursively(String word, TrieNode current, int index) {

        if (index == word.length()) {
            return current.isEndOfWord;
        }

        TrieNode tempNode = current.dataMap.get(word.charAt(index));

        if (tempNode == null) {
            return false;
        }

        current = tempNode;

        return searchRecursively(word, current, index + 1);
    }
}
