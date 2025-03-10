package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RepairBst {

    // Inorder traversal should give a sorted array. So we do an inorder
    // traversal using a stack, and keep a track of prev.
    // If curr.value <= prev.value, it is a problem.


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
        BST node1 = null, node2 = null;

        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree, prev = null;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (prev != null) {
                if (prev.value > curr.value) {
                    if (node1 == null) {
                        node1 = prev;
                    }
                    node2 = curr;
                }
            }

            prev = curr;
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

        if (node1 != null) {
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }

        return tree;
    }

}
