package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class YoungestCommonAncestor {

    // Generate the ancestral tree and then check when the nodes are equals.
    // Till not equal pop off nodes depending on the size of the queue.

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo) {

        Deque<AncestralTree> ancestorsOne = generateAncestors(descendantOne);
        Deque<AncestralTree> ancestorsTwo = generateAncestors(descendantTwo);

        while (ancestorsOne.peekFirst() != ancestorsTwo.peekFirst()) {
            int diff = ancestorsOne.size() - ancestorsTwo.size();
            if (diff == 0) {
                ancestorsOne.poll();
                ancestorsTwo.poll();
            } else if (diff > 0) {
                ancestorsOne.poll();
            } else {
                ancestorsTwo.poll();
            }
        }

        return ancestorsTwo.peekFirst();
    }

    private static Deque<AncestralTree> generateAncestors(AncestralTree node) {
        Deque<AncestralTree> ancestors = new ArrayDeque<>();
        while (node != null) {
            ancestors.offer(node);
            node = node.ancestor;
        }

        return ancestors;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
