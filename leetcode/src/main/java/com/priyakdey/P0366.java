package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> acc = new ArrayList<>();
        traverse(root, acc);
        return acc;
    }

    public int traverse(TreeNode node, List<List<Integer>> acc) {
        if (node == null) return -1;

        if (node.left == null && node.right == null) {
            if (acc.isEmpty()) {
                acc.add(new ArrayList<>());
            }
            acc.getFirst().add(node.val);
            return 0;
        }

        int level = Math.max(traverse(node.left, acc), traverse(node.right, acc)) + 1;
        // This should never hit, since this if for leaf nodes, which is handled above
        if (level == 0) {
            return -1;
        }

        if (acc.size() < level + 1) {
            acc.add(new ArrayList<>());
        }
        acc.get(level).add(node.val);
        return level;
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
