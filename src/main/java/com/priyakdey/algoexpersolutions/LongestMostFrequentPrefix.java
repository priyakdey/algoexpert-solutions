package com.priyakdey.algoexpersolutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class LongestMostFrequentPrefix {

    // Build a Trie with visit counts, then DFS to find the longest prefix shared by the most
    // strings — i.e., max visited, longest prefix.
    //
    // Each node tracks how many words pass through it; DFS collects the prefix path with
    // highest visited count.
    // Among equal frequencies, prefer the longer prefix — handled with tie-break condition.

    public String longestMostFrequentPrefix(String[] strings) {
        Trie trie = new Trie();
        for (String s : strings) {
            trie.addWord(s);
        }

        return trie.getPrefix();
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node((char) 0x0);
        }

        void addWord(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Node(ch));
                }
                curr = curr.children.get(ch);
                curr.visited++;
            }

            curr.terminal = true;
        }

        String getPrefix() {
            int maxFreq = 0;
            String prefix = "";

            for (Map.Entry<Character, Node> entry : root.children.entrySet()) {
                StringBuilder sb = new StringBuilder();
                int freq = getPrefixFreq(sb, entry.getKey(), entry.getValue(), root);
                if (freq > maxFreq) {
                    maxFreq = freq;
                    prefix = sb.toString();
                } else if (freq == maxFreq && sb.length() > prefix.length()) {
                    prefix = sb.toString();
                }
            }

            return prefix;
        }

        int getPrefixFreq(StringBuilder prefix, char ch, Node curr, Node parent) {
            if (curr.visited < parent.visited) return parent.visited;

            prefix.append(ch);
            if (curr.terminal || curr.children.isEmpty()) return curr.visited;

            int maxFreq = 0;

            for (Map.Entry<Character, Node> entry : curr.children.entrySet()) {
                int freq = getPrefixFreq(prefix, entry.getKey(), entry.getValue(), curr);
                maxFreq = Math.max(maxFreq, freq);
            }
            return maxFreq;
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
            this.visited = 0;
            this.children = new HashMap<>();
        }

    }

}
