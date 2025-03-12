package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class NodesAtKDistance {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target,
                                                 int k) {
        Deque<BinaryTree> roots = new ArrayDeque<>();
        BinaryTree curr = tree;
        while (curr != null) {
            roots.push(curr);
            curr = curr.left;
        }

        while (!roots.isEmpty()) {
            if (roots.peek().value == target) break;

            curr = roots.pop();
            curr = curr.right;
            while (curr != null) {
                roots.push(curr);
                curr = curr.left;
            }
        }

        ArrayList<Integer> closestNodes = new ArrayList<>();
        Set<BinaryTree> visited = new HashSet<>();
        while (!roots.isEmpty() && k > 0) {
            BinaryTree node = roots.pop();
            traverseDown(node, k, closestNodes, visited);
            visited.add(node);
            k--;
        }

        return closestNodes;
    }

    private void traverseDown(BinaryTree node, int k, ArrayList<Integer> acc,
                              Set<BinaryTree> visited) {
        if (node == null) return;
        if (k == 0) {
            acc.add(node.value);
            return;
        }

        traverseDown(node.left, k - 1, acc, visited);
        traverseDown(node.right, k - 1, acc, visited);
    }

}
