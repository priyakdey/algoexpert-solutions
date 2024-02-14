package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] array) {
        Objects.requireNonNull(array);
        int length = array.length;
        if (length == 0) return new int[] {};
        if (length == 1) return new int[] {-1};

        int[] nextGreaterElement = new int[length];
        Arrays.fill(nextGreaterElement, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int value = array[i];
            while (!stack.isEmpty() && value > array[stack.peek()]) {
                nextGreaterElement[stack.pop()] = value;
            }

            stack.push(i);
        }

        for (int i = 0; i < length; i++) {
            int value = array[i];
            while (!stack.isEmpty() && value > array[stack.peek()]) {
                nextGreaterElement[stack.pop()] = value;
            }

            stack.push(i);
        }

        return nextGreaterElement;
    }

}
