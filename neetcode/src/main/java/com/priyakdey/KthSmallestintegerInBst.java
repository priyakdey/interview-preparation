package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class KthSmallestintegerInBst {

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

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty() && k-- > 1) {
            node = stack.pop();

            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return stack.pop().val;
    }


}
