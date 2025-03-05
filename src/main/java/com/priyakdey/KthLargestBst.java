package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class KthLargestBst {

    // Use a stack to keep a track of the inorder traversal.

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        Deque<BST> stack = new ArrayDeque<>();

        BST curr = tree;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }

        while (!stack.isEmpty() && k > 1) {
            curr = stack.pop();
            k--;

            BST child = curr.left;
            while (child != null) {
                stack.push(child);
                child = child.right;
            }
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("not enough nodes");
        }

        return stack.peek().value;
    }

}
