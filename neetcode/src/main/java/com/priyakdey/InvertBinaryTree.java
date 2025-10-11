package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
