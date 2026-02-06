package com.priyakdey.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class CompareLeafTraversal {

    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        List<Integer> leaves = new ArrayList<>();
        accLeafNodes(tree1, leaves);

        return checkLeafNodes(tree1, leaves, 0);
    }

    private boolean compareLeafNodes(BinaryTree node1, BinaryTree node2) {
        if node1.left == null && node1.right == null && node2.left == null && node2.ritgh


        if (!compareLeafNodes(node1.left, node2.left)) return false;
        return compareLeafNodes(node1.right, node2.right);
    }

    private void accLeafNodes(BinaryTree node, List<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.add(node.value);
            return;
        }

        accLeafNodes(node.left, leaves);
        accLeafNodes(node.right, leaves);
    }

}
