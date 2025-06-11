package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class Semordnilap {

    // Insert each word into a Trie and check if its reverse exists as a terminal path —
    // if yes, it's a semordnilap pair.

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Trie trie = new Trie();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String word : words) {
            String pair = trie.searchReverseWord(word);
            if (pair != null) {
                result.add(new ArrayList<>(List.of(word, pair)));
            } else {
                trie.addWord(word);
            }
        }

        return result;
    }

    private static class Trie {
        Node root = new Node((char) 0x0);

        void addWord(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Node(ch));
                }
                curr = curr.children.get(ch);
            }

            curr.terminal = true;
        }

        String searchReverseWord(String word) {
            StringBuilder sb = new StringBuilder();
            Node curr = root;

            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!curr.children.containsKey(ch)) {
                    return null;
                }

                sb.append(ch);
                curr = curr.children.get(ch);
            }

            return curr.terminal ? sb.toString() : null;
        }

    }

    private static class Node {
        char ch;
        boolean terminal;
        Map<Character, Node> children;

        Node(char ch) {
            this.ch = ch;
            this.children = new HashMap<>();
        }

    }

}
