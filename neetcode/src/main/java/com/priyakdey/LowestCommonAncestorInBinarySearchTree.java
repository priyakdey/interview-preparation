package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class LowestCommonAncestorInBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) return root;

        TreeNode s = p.val < q.val ? p : q;
        TreeNode b = p.val > q.val ? p : q;

        if (s.val < root.val && b.val > root.val) {
            return root;
        }

        if (b.val < root.val) {
            return lowestCommonAncestor(root.left, s, b);
        } else {
            return lowestCommonAncestor(root.right, s, b);
        }
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
