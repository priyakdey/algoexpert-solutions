package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class FindKthLargestValueInBST {

    public int findKthLargestValueInBst(BST tree, int k) {
        if (k <= 0) throw new IllegalArgumentException("k needs to in the range[1, node_count]");

        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }


        while (!stack.isEmpty() && k > 0) {
            curr = stack.pop();
            BST child = curr.left;

            k--;

            while (child != null) {
                stack.push(child);
                child = child.right;
            }
        }

        if (k != 0) throw new IllegalArgumentException("k needs to in the range[1, node_count]");

        return curr.value;
    }


    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
