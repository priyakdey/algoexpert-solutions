package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidateThreeNodes {

    // Iterate from ancestor till you reach the node.
    // If you found the node, continue moving down the tree
    // to check if descendant is found.
    // Do this once with nodeOne as ancestor, nodeTwo as node
    // and nodeThree as descendant.
    // Do this a second time with nodeThree as ancestor, nodeTwo as node
    // and nodeOne as descendant.

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return validateNodeAsAncestorAndDescendant(nodeOne, nodeTwo, nodeThree)
                || validateNodeAsAncestorAndDescendant(nodeThree, nodeTwo, nodeOne);
    }

    private boolean validateNodeAsAncestorAndDescendant(BST ancestor,
                                                        BST node,
                                                        BST descendant) {
        BST curr = ancestor;

        while (curr != null && curr != node) {
            if (node.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) {
            return false;
        }

        while (curr != null && curr != descendant) {
            if (descendant.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return curr != null;
    }

}
