package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class ValidateThreeNodes {

    // Check if nodeTwo lies between nodeOne and nodeThree in BST order — one must be an ancestor
    // of nodeTwo, and the other its descendant.
    //
    // Use isDescendant() to check both directions:
    // If nodeTwo is in path from nodeOne → nodeTwo → nodeThree or nodeThree → nodeTwo → nodeOne,
    // return true.

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
        boolean isNodeOneDescendant = isDescendant(nodeTwo, nodeOne);
        boolean isNodeThreeDescendant = isDescendant(nodeTwo, nodeThree);

        if (!isNodeOneDescendant && !isNodeThreeDescendant) return false;

        if (isNodeOneDescendant) {
            return isDescendant(nodeThree, nodeTwo);
        }

        return isDescendant(nodeOne, nodeTwo);
    }

    private boolean isDescendant(BST root, BST node) {
        BST curr = root;

        while (curr != null) {
            if (curr == node) return true;
            else if (node.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return false;
    }


}
