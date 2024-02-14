package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        if (tree.left == null && tree.right == null) {
            array.add(tree.value);
            return array;
        }

        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();

            array.add(curr.value);

            BST child = curr.right;
            while (child != null) {
                stack.push(child);
                child = child.left;
            }
        }

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        if (tree.left == null && tree.right == null) {
            array.add(tree.value);
            return array;
        }

        Deque<BST> stack = new ArrayDeque<>();
        BST curr = tree;
        while (curr != null) {
            array.add(curr.value);
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            curr = stack.pop();

            BST child = curr.right;
            while (child != null) {
                array.add(child.value);
                stack.push(child);
                child = child.left;
            }
        }

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) return array;
        if (tree.left == null && tree.right == null) {
            array.add(tree.value);
            return array;
        }

        Deque<Pair> stack = new ArrayDeque<>();
        BST curr = tree;
        while (curr != null) {
            stack.push(new Pair(curr));
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.peek();
            BST node = pair.node;
            boolean visitRightChild = pair.visitRightChild;

            if (!visitRightChild) {
                stack.pop();
                array.add(node.value);
            } else {
                stack.peek().visitRightChild = false;
                BST child = node.right;
                while (child != null) {
                    stack.push(new Pair(child));
                    child = child.left;
                }
            }
        }

        return array;
    }

    private static class Pair {
        private final BST node;
        private boolean visitRightChild;

        Pair(BST node) {
            this.node = node;
            visitRightChild = true;
        }

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
