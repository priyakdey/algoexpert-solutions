package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class EvaluateExpressionTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree == null) {
            throw new IllegalArgumentException("invalid expression");
        }
        if (tree.left == null && tree.right == null) {
            return tree.value;
        }
        if (tree.left == null || tree.right == null) {
            throw new IllegalArgumentException("invalid expression");
        }

        final int lhs = evaluateExpressionTree(tree.left);
        final int rhs = evaluateExpressionTree(tree.right);
        return switch (tree.value) {
            case -1 -> lhs + rhs;
            case -2 -> lhs - rhs;
            case -3 -> {
                if (rhs != 0) yield lhs / rhs;
                throw new IllegalArgumentException("cannot divide by zero");
            }
            case -4 -> lhs * rhs;
            default -> throw new IllegalArgumentException("invalid operation");
        };
    }

}
