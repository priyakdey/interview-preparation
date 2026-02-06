package com.priyakdey.binarytree;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        invertBinaryTreeInternal(tree);
    }

    private static BinaryTree invertBinaryTreeInternal(BinaryTree node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        BinaryTree leftChild  = invertBinaryTreeInternal(node.left);
        BinaryTree rightChild = invertBinaryTreeInternal(node.right);

        node.left  = rightChild;
        node.right = leftChild;

        return node;
    }

}
