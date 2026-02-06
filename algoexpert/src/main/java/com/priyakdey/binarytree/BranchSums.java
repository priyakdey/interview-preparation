package com.priyakdey.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> acc = new ArrayList<>();
        branchSums(root, 0, acc);
        return acc;
    }

    private static void branchSums(BinaryTree node, int currSum,
                                   List<Integer> acc) {
        currSum += node.value;
        if (node.left == null && node.right == null) {
            acc.add(currSum);
        }

        if (node.left != null) {
            branchSums(node.left, currSum, acc);
        }

        if (node.right != null) {
            branchSums(node.right, currSum, acc);
        }

    }

}
