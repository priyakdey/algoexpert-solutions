package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                TrieNode curr = root;
                for (int j = i; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        curr.children.put(c, new TrieNode());
                    }
                    curr = curr.children.get(c);
                }
                curr.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return curr.children.containsKey(endSymbol);
        }
    }

}
