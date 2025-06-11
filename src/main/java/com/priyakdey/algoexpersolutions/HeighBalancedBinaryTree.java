package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class HeighBalancedBinaryTree {


    // Recursively compute height while tracking the max left–right subtree difference —
    // tree is height-balanced if max difference ≤ 1.
    //
    // Use postorder traversal to compute subtree heights and update the max diff.
    // Avoid recomputation and short-circuit early if any subtree is already unbalanced
    // for optimization.

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int[] maxDiff = {0};
        heightOfTree(tree, maxDiff);
        return maxDiff[0] <= 1;
    }

    public int heightOfTree(BinaryTree node, int[] maxDiff) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int leftHeight = heightOfTree(node.left, maxDiff);
        int rightHeight = heightOfTree(node.right, maxDiff);

        int diff = leftHeight - rightHeight;
        maxDiff[0] = Math.max(Math.abs(diff), maxDiff[0]);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
