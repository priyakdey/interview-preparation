package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] sumRef = {Integer.MIN_VALUE};
        maxPathSum(root, sumRef);
        return sumRef[0];
    }

    private int maxPathSum(TreeNode node, int[] sumRef) {
        int val = node.val;
        if (node.left == null && node.right == null) {
            sumRef[0] = max(sumRef[0], val);
            return val;
        }

        int leftSum = 0, rightSum = 0;

        if (node.left != null) {
            leftSum = maxPathSum(node.left, sumRef);
        }

        if (node.right != null) {
            rightSum = maxPathSum(node.right, sumRef);
        }

        sumRef[0] = max(sumRef[0], val, leftSum + val, rightSum + val,
                leftSum + rightSum + val);

        return max(val, leftSum + val, rightSum + val);
    }

    private int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }

        return max;
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
