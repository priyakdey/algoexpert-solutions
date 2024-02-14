package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RepairBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public BST repairBst(BST tree) {
        if (tree == null || (tree.left == null && tree.right == null)) return tree;

        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        BST prev = null;

        BST first  = null;
        BST second = null;

        while (!stack.isEmpty()) {
            curr = stack.pop();

            if (prev != null && prev.value > curr.value) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }

            prev = curr;

            BST child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }

        if (first != null) {
            int temp = first.value;
            first.value = second.value;
            second.value = temp;
        }

        return tree;
    }

}
