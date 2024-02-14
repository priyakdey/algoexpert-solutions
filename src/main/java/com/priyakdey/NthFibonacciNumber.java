package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NthFibonacciNumber {

    public static int getNthFib(int n) {
        if (n <= 2) return n - 1;

        int previous = 0, current = 1;
        for (int i = 3; i <= n; i++) {
            int temp = previous;
            previous = current;
            current += temp;
        }

        return current;
    }

}
