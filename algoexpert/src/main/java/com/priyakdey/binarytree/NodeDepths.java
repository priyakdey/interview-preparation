package com.priyakdey.binarytree;

/**
 * @author Priyak Dey
 */
public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        if (root == null) return 0;
        return depthAtNode(root, 0);
    }

    private static int depthAtNode(BinaryTree node, int currDepth) {
        if (node.left == null && node.right == null) {
            return currDepth;
        }

        int left = node.left != null ?
                depthAtNode(node.left, currDepth + 1) : 0;


        int right = node.right != null ?
                depthAtNode(node.right, currDepth + 1) : 0;

        return currDepth + left + right;
    }
}
