package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target,
                                                 int k) {
        // find the target node
        Deque<BinaryTree> stack = new ArrayDeque<>();
        BinaryTree curr = tree;
        ArrayList<Integer> nodes = new ArrayList<>();

        while (curr != null) {
            stack.push(curr);
            if (target == curr.value) {
                break;
            } else if (target < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) {
            return nodes;
        }

        // find the k-distance descendants
        traverseDown(curr, k, nodes);

        // find the k-distance ancestors, or children of ancestors in
        // diff branches
        BinaryTree prev = null;
        int distanceFromTarget = 0;
        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            distanceFromTarget++;

            if (distanceFromTarget == k) {
                nodes.add(node.value);
                continue;
            }

            if (node.left != null && node.left != prev) {
                traverseDown(node.left, k - distanceFromTarget - 1, nodes);
            }
            if (node.right != null && node.right != prev) {
                traverseDown(node.right, k - distanceFromTarget - 1, nodes);
            }

            prev = node;
        }

        return nodes;
    }


    private void traverseDown(BinaryTree node, int k, ArrayList<Integer> acc) {
        if (node == null) return;
        if (k == 0) {
            acc.add(node.value);
            return;
        }

        traverseDown(node.left, k - 1, acc);
        traverseDown(node.right, k - 1, acc);
    }

}
