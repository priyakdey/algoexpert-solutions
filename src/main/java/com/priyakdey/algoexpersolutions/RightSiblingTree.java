package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class RightSiblingTree {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            BinaryTree curr = queue.poll();

            BinaryTree left = curr.left;
            BinaryTree right = curr.right;

            curr.right = queue.peek();

            queue.offer(left);
            queue.offer(right);
        }

        root.right = null;
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
