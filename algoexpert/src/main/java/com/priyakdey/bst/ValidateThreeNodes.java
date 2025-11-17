package com.priyakdey.bst;

/**
 * @author priyakdey
 */
public class ValidateThreeNodes {

    // First we start from nodeOne, and go down till we reach ndoTwo.
    // If we do, we know that nodeOne is an ancestor on nodeTwo.
    // Keep traversing down from nodeTwo to find if nodeThree is a descendant.
    //
    // If nodeOne is not ancestor, we can do the same trick, start traversing from
    // nodeThree, and reach nodeTwo.
    // If we can, we can then keep traversing down to find nodeOne.
    //
    // If none of the cases satisfies, we just say false.
    //
    // Even though we have multiple branches, each branch is executed once, so in worse, we first traverse
    // nodeOne -> nodeTwo(null). Then we again start from nodeThree to nodeTwo.
    //
    // So the time complexity is O(h) with worst cases as O(n) with skewed tree.

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {

        boolean isOneAncestor = false;

        // Go down from nodeOne till we nodeTwo
        BST curr = nodeOne;
        while (curr != null) {
            if (curr.value == nodeTwo.value) {
                isOneAncestor = true;
                break;
            } else if (nodeTwo.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (isOneAncestor) {
            // go down curr to see if nodeThree is a descendant
            while (curr != null) {
                if (curr.value == nodeThree.value) {
                    return true;
                } else if (nodeThree.value < curr.value) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            return false;
        }

        // If not, we start from nodeThree and try reaching nodeTwo
        boolean isThreeAncestor = false;

        curr = nodeThree;
        while (curr != null) {
            if (curr.value == nodeTwo.value) {
                isThreeAncestor = true;
                break;
            } else if (nodeTwo.value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (isThreeAncestor) {
            // go down curr to see if nodeOne is a descendant
            while (curr != null) {
                if (curr.value == nodeOne.value) {
                    return true;
                } else if (nodeOne.value < curr.value) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            return false;
        }

        return false;
    }

}
