package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class FlattenBinaryTree {

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        Deque<BinaryTree> stack = new ArrayDeque<>();
        BinaryTree curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        root = stack.peek();

        BinaryTree prev = null;

        while (!stack.isEmpty()) {
            curr = stack.pop();

            BinaryTree child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }

            curr.left = prev;
            prev = curr;
            curr.right = !stack.isEmpty() ? stack.peek() : null;
        }

        return root;
    }


    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
