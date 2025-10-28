package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> acc = new ArrayList<>();
        acc.add(new ArrayList<>());

        verticalOrder(root, 0, acc, 0);
        return acc;
    }

    private void verticalOrder(TreeNode node, int offset, List<List<Integer>> acc, int origin) {
        if (node == null) return;

        if (offset == 0) {
            acc.get(origin).add(node.val);
        } else if (offset < 0) {
            int length = origin - 1 - offset + 1;
            if (origin - offset >= length) {
                acc.addFirst(new ArrayList<>());
                origin++;
            }
            acc.get(origin - offset).add(node.val);
        } else {
            int i = origin + offset;
            if (i >= acc.size()) {
                acc.addLast(new ArrayList<>());
            }
            acc.get(i).add(node.val);
        }

        verticalOrder(node.left, offset - 1, acc, origin);
        verticalOrder(node.right, offset + 1, acc, origin);
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
