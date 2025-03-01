package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class NextGreaterElement {

    // Use a stack to figure out, current element is greater than
    // which previous elements.

    public int[] nextGreaterElement(int[] array) {
        Deque<Pair> stack = new ArrayDeque<>();
        int length = array.length;
        int[] nextGreaterElements = new int[length];
        Arrays.fill(nextGreaterElements, -1);

        for (int i = 0; i < length; i++) {
            int value = array[i];
            while (!stack.isEmpty() && value > stack.peek().value) {
                Pair pair = stack.pop();
                nextGreaterElements[pair.index] = value;
            }

            stack.push(new Pair(value, i));
        }

        for (int i = 0; i < length; i++) {
            int value = array[i];
            while (!stack.isEmpty() && value > stack.peek().value) {
                Pair pair = stack.pop();
                nextGreaterElements[pair.index] = value;
            }

            stack.push(new Pair(value, i));
        }

        return nextGreaterElements;
    }

    private record Pair(int value, int index) {
    }

}
