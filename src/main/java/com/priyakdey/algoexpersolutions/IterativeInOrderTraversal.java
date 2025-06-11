package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

/**
 * @author Priyak Dey
 */
public class IterativeInOrderTraversal {

    // Classic iterative inorder traversal using a stack — dive left, process node, then
    // explore right subtree.

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

            BinaryTree right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
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
