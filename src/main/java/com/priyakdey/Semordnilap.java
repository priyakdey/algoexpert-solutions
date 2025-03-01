package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Semordnilap {

    // Create a trie to use as a map. insert in straight order, while
    // search in reverse order.

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> semordnilaps = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            String reverse = trie.searchReverse(word);
            if (reverse == null) {
                trie.insert(word);
            } else {
                semordnilaps.add(new ArrayList<>(List.of(reverse, word)));
            }
        }

        return semordnilaps;
    }

    private static class Trie {
        private final Node root;

        private Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }

            curr.end = true;
        }

        public String searchReverse(String word) {
            Node curr = root;
            StringBuilder buf = new StringBuilder(word.length());

            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                buf.append(ch);
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    return null;
                }

                curr = curr.children[index];
            }

            if (!curr.end) {
                return null;
            }

            return buf.toString();
        }

    }

    private static class Node {
        private final Node[] children;
        private boolean end;

        private Node() {
            this.children = new Node[26];
        }
    }

}
