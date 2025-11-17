package com.priyakdey.bst;

/**
 * @author priyakdey
 */
public class SumBSTs {

    // TODO: need to complete this

    public int sumBsts(BinaryTree tree) {
        Result result = sumBstsInternal(tree);
        return result.currSum;
    }

    private Result sumBstsInternal(BinaryTree node) {
        if (node.left == null && node.right == null) {
            return new Result(node.value, node.value, node.value, 1, true);
        }

        int sum = node.value;
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;
        int count = 0;
        boolean isBst = false;

        if (node.left != null) {
            Result left = sumBstsInternal(node.left);
            System.out.println(left);
            // current node is a valid root node of the left subtree, if left subtree is a bst
            // and current node value > max value we got from the left subtree
            if (left.isBst && node.value > left.maxValue && 1 + left.count >= 3) {
                sum += left.currSum;
                maxValue = node.value;
                minValue = left.minValue;
                count += left.count;
                isBst = true;
            }
        }

        if (!isBst) {
            // if node cannot be a good parent of the left subtree, we can short circuit.
            return new Result(sum, minValue, maxValue, count, false);
        }

        if (node.right != null) {
            Result right = sumBstsInternal(node.right);
            // current node is a valid root node of the left subtree, if left subtree is a bst
            // and current node value <= min value we got from the right subtree
            if (right.isBst && node.value <= right.minValue && 1 + right.count >= 3) {
                sum += right.currSum;
                maxValue = right.maxValue;
                minValue = node.value;
                count += right.count;
            } else {
                return new Result(sum, minValue, maxValue, count, false);
            }
        }

        return new Result(sum, minValue, maxValue, count + 1, true);
    }

    /**
     * Dataclass to hold the result value of the internal function
     *
     * @param currSum  total cumulative sum till now
     * @param minValue min value of the subtree
     * @param maxValue max value of the subtree
     * @param isBst    flag to determine if subtree is a BST
     */
    private record Result(int currSum, long minValue, long maxValue, int count, boolean isBst) {
    }

}
