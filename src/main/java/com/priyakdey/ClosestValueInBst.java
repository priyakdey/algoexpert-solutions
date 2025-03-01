package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ClosestValueInBst {

    // Do a binary search and keep a track of min difference with the target.

    public static int findClosestValueInBst(BST tree, int target) {
        assert tree != null;    // does not say what is expected
        int closestValue = tree.value;
        BST curr = tree;
        int minDiff = Math.abs(tree.value - target);

        while (curr != null) {
            int diff = Math.abs(target - curr.value);
            if (diff < minDiff) {
                minDiff = diff;
                closestValue = curr.value;
            }
            if (target == curr.value) {
                break;
            } else if (target < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return closestValue;
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
