package com.priyakdey.algoexpersolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class ShortestUniquePrefix {

    // Build a Trie that tracks visit counts on each node — the shortest unique prefix is the path
    // until the first node with visited == 1.
    //
    // As you insert words, increment visited per node.
    // To get the shortest unique prefix, traverse until the path diverges (visited == 1) — that’s
    // your uniqueness boundary.

    public String[] shortestUniquePrefixes(String[] strings) {
        Trie trie = new Trie();
        for (String s : strings) {
            trie.addWord(s);
        }

        int length = strings.length;
        String[] prefixes = new String[length];

        for (int i = 0; i < length; i++) {
            prefixes[i] = trie.getUniquePrefix(strings[i]);
        }

        return prefixes;
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node((char) 0x0);
        }

        void addWord(String word) {
            Node curr = this.root;

            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Node(ch));
                }
                curr = curr.children.get(ch);
                curr.visited++;
            }

            curr.terminal = true;
        }

        String getUniquePrefix(String word) {
            Node curr = this.root;
            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                if (curr.visited == 1) {
                    break;
                }
                curr = curr.children.get(ch);
                sb.append(ch);
            }

            return sb.toString();
        }
    }

    static class Node {
        char ch;
        boolean terminal;
        int visited;
        Map<Character, Node> children;

        Node(char ch) {
            this.ch = ch;
            this.terminal = false;
            visited = 0;
            this.children = new HashMap<>();
        }

    }

}
