package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class BalancedBrackets {

    private static final Map<Character, Character> mappings = Map.of(')', '(', '}', '{', ']', '[');

    public static boolean balancedBrackets(String str) {
        Objects.requireNonNull(str);
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (mappings.containsKey(ch)) {
                if (!stack.isEmpty() || !Objects.equals(stack.pop(), mappings.get(ch))) {
                    return false;
                }
            } else if (mappings.containsValue(ch)) {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
