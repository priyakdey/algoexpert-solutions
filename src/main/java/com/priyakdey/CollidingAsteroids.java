package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class CollidingAsteroids {

    // Use a stack to look back at previous asteroid to check
    // if collision is required.

    public int[] collidingAsteroids(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean shouldPush = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.pop();
                asteroid = -asteroid;
                if (asteroid == top) {
                    shouldPush = false;
                    break;
                } else if (asteroid > top) {
                    asteroid = -asteroid;
                } else {
                    asteroid = top;
                }
            }

            if (shouldPush) {
                stack.push(asteroid);
            }
        }

        int stackSize = stack.size();
        int[] result = new int[stackSize];
        for (int i = stackSize - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
