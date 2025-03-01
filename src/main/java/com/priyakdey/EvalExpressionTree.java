package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class EvalExpressionTree {

    // walk down the tree to the leaf nodes which are operands and return them.
    // result from left node = lhs and right node = rhs
    // perform the operation on the lhs and rhs depending on the tree.value

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            assert tree.value > 0;
            return tree.value;
        }

        assert tree.left != null;
        assert tree.right != null;

        int lhs = evaluateExpressionTree(tree.left);
        int rhs = evaluateExpressionTree(tree.right);

        return switch (tree.value) {
            case -1 -> lhs + rhs;
            case -2 -> lhs - rhs;
            case -3 -> lhs / rhs;
            case -4 -> lhs * rhs;
            default ->
                    throw new IllegalStateException("Unexpected value: " + tree.value);
        };
    }

}
