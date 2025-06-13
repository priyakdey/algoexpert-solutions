package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RepairBST {

    // Recover a BST with two swapped nodes by performing in-order traversal — detect the two
    // out-of-order nodes and swap their values.
    //
    // During in-order traversal, the previous node should always be < current — if not, store
    // the mismatched pair.
    // Swap the first offending node (badOne) with the last (badTwo) after traversal to fix the
    // tree.
    // Always store prev as badOne and current as badTwo. If a second mismatch occurs, replace
    // badTwo with current.

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST repairBst(BST tree) {
        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree;

        BST badOne = null;
        BST badTwo = null;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        BST prev = null;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (prev != null && curr.value < prev.value) {
                if (badOne == null) {
                    badOne = prev;
                }
                badTwo = curr;
            }

            prev = curr;
            BST child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }

        if (badOne != null) {
            int value = badOne.value;
            badOne.value = badTwo.value;
            badTwo.value = value;
        }

        return tree;
    }

}
