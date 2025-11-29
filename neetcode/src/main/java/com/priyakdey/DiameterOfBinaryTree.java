package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class DiameterOfBinaryTree {

    // max diameter at any node which can help increase diameter for its parent
    //  = max (1 + max at left child, 1 + max at right child)
    // For max diameter at that node =
    //  = max (left, right, left + right)
    // NOTE: Just visualize, and it should make sense, most likely !!

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] maxDiameterRef = new int[]{0};
        getMaxHeightAtNode(root, maxDiameterRef);
        return maxDiameterRef[0];
    }

    private int getMaxHeightAtNode(TreeNode node, int[] maxDiameterRef) {
        if (node.left == null && node.right == null) return 0;

        int leftDiameter = 0, rightDiameter = 0;

        if (node.left != null) {
            leftDiameter = 1 + getMaxHeightAtNode(node.left, maxDiameterRef);
        }

        if (node.right != null) {
            rightDiameter = 1 + getMaxHeightAtNode(node.right, maxDiameterRef);
        }

        maxDiameterRef[0] = max(maxDiameterRef[0], leftDiameter, rightDiameter,
                leftDiameter + rightDiameter);


        return max(leftDiameter, rightDiameter);
    }

    private int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }

        return max;
    }

}
