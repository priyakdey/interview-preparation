package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int index, int[] inorder, int from, int end) {
        if (from > end) return null;

        int value = preorder[index];
        TreeNode node = new TreeNode(value);

        int k = from;
        while (inorder[k] != value) {
            k++;
        }

        // left  elements in
        // inorder - [from..k - 1]
        // preorder - [index + 1...]
        int leftElementCount = k - from;
        node.left = buildTree(preorder, index + 1, inorder, from , k - 1);

        // right elements in
        // inorder - [k + 1..end]
        // preorder - [index + 1 + leftElementCount...]
        node.right = buildTree(preorder, index + 1 + leftElementCount, inorder, k + 1,
                end);

        return node;
    }
}
