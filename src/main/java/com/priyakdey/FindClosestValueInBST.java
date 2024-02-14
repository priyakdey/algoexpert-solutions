package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class FindClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = tree.value;
        int minDiff = Math.abs(tree.value - target);

        BST curr = tree;

        while (curr != null) {
            if (curr.value == target) {
                closestValue = curr.value;
                break;
            }

            int absDiff = Math.abs(curr.value - target);
            if (absDiff < minDiff) {
                minDiff = absDiff;
                closestValue = curr.value;
            }

            if (target < curr.value) {
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
