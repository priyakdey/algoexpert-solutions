package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class CollidingAsteroids {

    public int[] collidingAsteroids(int[] asteroids) {
        Objects.requireNonNull(asteroids);
        int length = asteroids.length;

        // if empty -> push element
        // if not empty ->
        //  1. curr = +ve and top +ve -> push
        //  2. curr = +ve and top -ve -> push
        //  3. curr = -ve and top +ve -> collide
        //  4. curr = -ve and top -ve -> push

        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            int currAsteroid = asteroid;
            while (!stack.isEmpty() && stack.peek() > 0 && currAsteroid < 0) {
                int top = stack.pop();
                int absVal = -currAsteroid;
                if (top == absVal) {
                    currAsteroid = 0;
                } else if (top > absVal) {
                    currAsteroid = top;
                }
            }

            if (currAsteroid != 0) stack.push(currAsteroid);
        }

        int[] survivor = new int[stack.size()];
        int cursor = stack.size() - 1;
        while (!stack.isEmpty()) {
           survivor[cursor--] = stack.pop();
        }

        return survivor;
    }

}
