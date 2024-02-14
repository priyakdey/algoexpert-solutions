package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class Semordnilap {

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> pairs = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            if (trie.findReverse(word)) {
                if (word.isEmpty()) continue;
                ArrayList<String> pair = new ArrayList<>(2);
                pair.add(new StringBuilder(word).reverse().toString());
                pair.add(word);
                pairs.add(pair);
            } else {
                trie.addWord(word);
            }
        }

        return pairs;
    }

    private static class Trie {
        private final Node root;

        Trie() {
            this.root = new Node();
        }

        void addWord(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch;
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }

            curr.isWord = true;
        }

        boolean findReverse(String word) {
            Node curr = root;

            for (int length = word.length(), i = length - 1; i >= 0; i--) {
                int index = (int) word.charAt(i);
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }

            return curr.isWord;
        }

        private static class Node {
            final Node[] children;
            boolean isWord;

            Node() {
                this.children = new Node[256];
            }

        }

    }

}
