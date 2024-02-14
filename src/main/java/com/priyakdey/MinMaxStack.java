package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class MinMaxStack {

    private final Deque<Triplet> stack;

    public MinMaxStack() {
        this.stack = new ArrayDeque<>();
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().value;
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop().value;
    }

    public void push(Integer number) {
        if (stack.isEmpty()) {
            stack.push(new Triplet(number, number, number));
            return;
        }

        int currMin = getMin(), currMax = getMax();
        int min = Math.min(currMin, number);
        int max = Math.max(currMax, number);
        stack.push(new Triplet(number, max, min));
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().min;
    }

    public int getMax() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek().max;
    }

    private record Triplet(int value, int max, int min) {
    }


}
