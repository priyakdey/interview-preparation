package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BalancedBinaryTree {

    // At each node, we can return the height for recursive calls,
    // along with if the node is balanced, if not, we can short-circuit.
    // If balanced, we can consider if parent is balanced. If so,
    // we return 1 + max(leftHeight, rightHeight) as the height for the
    // previous recursive call from parent.

    // In this problem, instead of doing pure OOPs, with given constraint of
    // 1000 nodes, we use an int32 (int in java) to encode the data.
    // We use lower 10 bits to represent the height.
    // And 11th bit to represent the boolean....!!


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int result = heightAt(root);
        return ((result >> 11) & 1) == 1;
    }

    private int heightAt(TreeNode node) {
        if (node.left == null && node.right == null) {
            return (1 << 11) ^ 1;
        }

        int leftHeight = 0, rightHeight = 0;
        if (node.left != null) {
            int leftResult = heightAt(node.left);
            boolean isBalanced = ((leftResult >> 11) & 1) == 1;
            if (!isBalanced) {
                return 0;
            }

            leftHeight = leftResult & 0x3FF;
        }

        if (node.right != null) {
            int rightResult = heightAt(node.right);
            boolean isBalanced = ((rightResult >> 11) & 1) == 1;
            if (!isBalanced) {
                return 0;
            }

            rightHeight = rightResult & 0x3FF;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) return 0;

        return (1 << 11) ^ (1 + Math.max(leftHeight, rightHeight));
    }

    private Result heightAtUsingOOPs(TreeNode node) {
        if (node.left == null && node.right == null) {
            // we need to return 1 as height for leaf nodes,
            // so the maths does not fuck up
            return new Result(1, true);
        }

        int leftHeight = 0, rightHeight = 0;

        if (node.left != null) {
            Result leftResult = heightAtUsingOOPs(node.left);
            // we can short-circuit
            if (!leftResult.isBalanced) return new Result(-1, false);

            leftHeight = leftResult.height;
        }

        if (node.right != null) {
            Result rightResult = heightAtUsingOOPs(node.right);
            // we can short-circuit
            if (!rightResult.isBalanced) return new Result(-1, false);

            rightHeight = rightResult.height;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) return new Result(-1, false);

        return new Result(1 + Math.max(leftHeight, rightHeight), true);
    }

    private record Result(int height, boolean isBalanced) {
    }

}
