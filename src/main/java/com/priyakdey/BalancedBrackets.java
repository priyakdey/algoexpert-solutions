package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class BalancedBrackets {

    // Use a stack to figure out if current closing bracket has a corresponding
    // opening bracket.

    public static boolean balancedBrackets(String str) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Set<Character> openBrackets = Set.of('(', '{', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (openBrackets.contains(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
