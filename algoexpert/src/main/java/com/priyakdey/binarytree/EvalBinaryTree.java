package com.priyakdey.binarytree;

/**
 * @author Priyak Dey
 */
public class EvalBinaryTree {

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree == null) return 0;
        if (tree.left == null && tree.right == null) return tree.value;

        int lhs = evaluateExpressionTree(tree.left);
        int rhs = evaluateExpressionTree(tree.right);

        return switch(tree.value) {
            case -1 -> lhs + rhs;
            case -2 -> lhs - rhs;
            case -3 -> {
                if (rhs == 0) throw new ArithmeticException("NaN");
                yield lhs / rhs;
            }
            case -4 -> lhs * rhs;
            default -> throw new IllegalArgumentException("invalid expression");
        };
    }

}
