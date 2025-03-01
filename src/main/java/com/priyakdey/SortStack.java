package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class SortStack {

    // Use a second stack to sort the array in desc order.
    // Once main stack is empty, move all elements from temp stack
    // into main stack and return it.

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        sortStack(stack, new ArrayList<>());
        return stack;
    }

    private void sortStack(ArrayList<Integer> stack,
                           ArrayList<Integer> sortedStack) {
        if (stack.isEmpty()) {
            while (!sortedStack.isEmpty()) {
                stack.add(sortedStack.removeLast());
            }
            return;
        }

        int top = stack.removeLast();
        while (!sortedStack.isEmpty() && sortedStack.getLast() < top) {
            stack.add(sortedStack.removeLast());
        }

        sortedStack.add(top);
        sortStack(stack, sortedStack);
    }

}
