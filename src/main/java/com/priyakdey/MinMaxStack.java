package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinMaxStack {

    private final Deque<Tuple> stack = new ArrayDeque<>();

    public int peek() {
        assert !stack.isEmpty();
        return stack.peek().value;
    }

    public int pop() {
        assert !stack.isEmpty();
        return stack.pop().value;
    }

    public void push(Integer number) {
        int min = number, max = number;
        if (!stack.isEmpty()) {
            min = Math.min(min, getMin());
            max = Math.max(max, getMax());
        }

        stack.push(new Tuple(number, max, min));
    }

    public int getMin() {
        assert !stack.isEmpty();
        return stack.peek().min;
    }

    public int getMax() {
        assert !stack.isEmpty();
        return stack.peek().max;
    }

    private record Tuple(int value, int max, int min) {
    }
}
