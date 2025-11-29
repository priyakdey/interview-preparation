package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class CountGoodNodesInBinaryTree {

    // From root, pass down max value we have seen till now.
    // If node.val >= max value till now - it s a good node.
    // Traverse down the tree left and right and get total count.
    // Take care of null!!

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode node, int maxValueTill) {
        if (node.left == null && node.right == null) {
            return node.val >= maxValueTill ? 1 : 0;
        }

        maxValueTill = Math.max(maxValueTill, node.val);

        int count = node.val >= maxValueTill ? 1 : 0;

        if (node.left != null) {
            count += goodNodes(node.left, maxValueTill);
        }
        if (node.right != null) {
            count += goodNodes(node.right, maxValueTill);
        }

        return count;
    }

}
