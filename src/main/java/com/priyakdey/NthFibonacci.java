package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class NthFibonacci {

    public static int getNthFib(int n) {
        int curr = 0, next = 1;
        while (n > 1) {
            int temp = curr;
            curr = next;
            next = temp + next;
            n--;
        }

        return curr;
    }

}
