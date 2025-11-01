package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P0298 {

    public int longestConsecutive(TreeNode root) {
        int[] max = {0};
        longestConsecutive(root, max);
        return max[0];
    }

    private int longestConsecutive(TreeNode node, int[] max) {
        if (node.left == null && node.right == null) {
            max[0] = Math.max(max[0], 1);
            return 1;
        }

        int left = 0, right = 0;

        if (node.left != null) {
            int _left = longestConsecutive(node.left, max);
            if (node.val + 1 == node.left.val) {
                left = _left;
            }
        }

        if (node.right != null) {
            int _right = longestConsecutive(node.right, max);
            if (node.val + 1 == node.right.val) {
                right = _right;
            }
        }

        int _max = 1 + Math.max(left, right);
        max[0] = Math.max(max[0], _max);
        return _max;
    }

    private static class TreeNode {
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
