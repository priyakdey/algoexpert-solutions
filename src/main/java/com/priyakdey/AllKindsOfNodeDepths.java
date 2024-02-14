package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class AllKindsOfNodeDepths {

    public static int allKindsOfNodeDepths(BinaryTree root) {
        int[] sum = {0};
        allKindsOfNodeDepths(root, sum);
        return sum[0];
    }

    private static int allKindsOfNodeDepths(BinaryTree root, int[] sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int leftDepth  = allKindsOfNodeDepths(root.left, sum);
        int rightDepth = allKindsOfNodeDepths(root.right, sum);

        int depthAtNode = 0;
        if (root.left != null)  depthAtNode += 1 + leftDepth;
        if (root.right != null) depthAtNode += 1 + rightDepth;

        sum[0] += depthAtNode + leftDepth + rightDepth;

        return depthAtNode;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
