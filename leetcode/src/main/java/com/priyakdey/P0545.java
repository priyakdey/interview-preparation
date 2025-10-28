package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> buffer = new ArrayList<>();
        buffer.add(root.val);

        if (root.left == null && root.right == null) {
            return buffer;
        }

        traverseLeftBoundary(root.left, buffer);
        traverseLeafNodes(root, buffer);
        traverseRightBoundary(root.right, buffer);

        return buffer;
    }

    private void traverseLeftBoundary(TreeNode node, List<Integer> buffer) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        buffer.add(node.val);

        if (node.left != null) {
            traverseLeftBoundary(node.left, buffer);
        } else {
            traverseLeftBoundary(node.right, buffer);
        }
    }

    private void traverseLeafNodes(TreeNode node, List<Integer> buffer) {
        if (node.left == null && node.right == null) {
            buffer.add(node.val);
            return;
        }

        if (node.left != null) {
            traverseLeafNodes(node.left, buffer);
        }

        if (node.right != null) {
            traverseLeafNodes(node.right, buffer);
        }
    }

    private void traverseRightBoundary(TreeNode node, List<Integer> buffer) {
        if (node == null) return;
        if (node.left == null && node.right == null) return;

        if (node.right != null) {
            traverseRightBoundary(node.right, buffer);
        } else {
            traverseRightBoundary(node.left, buffer);
        }
        buffer.add(node.val);
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
