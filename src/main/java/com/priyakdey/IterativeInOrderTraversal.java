package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

/**
 * @author Priyak Dey
 */
public class IterativeInOrderTraversal {

    public static void iterativeInOrderTraversal(BinaryTree tree,
                                                 Function<BinaryTree, Void> callback) {
        Deque<BinaryTree> stack = new ArrayDeque<>();
        BinaryTree curr = tree;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();

            callback.apply(curr);

            BinaryTree child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
