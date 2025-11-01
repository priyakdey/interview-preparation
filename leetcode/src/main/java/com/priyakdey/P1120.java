package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P1120 {

    public double maximumAverageSubtree(TreeNode root) {
        double[] max = {0};
        maximumAverageSubtree(root, max);
        return max[0];
    }

    public Pair maximumAverageSubtree(TreeNode node, double[] max) {
        if (node.left == null && node.right == null) {
            max[0] = Math.max(max[0], node.val);
            return new Pair(node.val, 1);
        }

        int sum = node.val;
        int count = 1;

        if (node.left != null) {
            Pair pair = maximumAverageSubtree(node.left, max);
            sum += pair.sum;
            count += pair.count;
        }

        if (node.right != null) {
            Pair pair = maximumAverageSubtree(node.right, max);
            sum += pair.sum;
            count += pair.count;
        }


        max[0] = Math.max(max[0], (double) sum / count);
        return new Pair(sum, count);
    }

    private record Pair(int sum, int count) {
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
