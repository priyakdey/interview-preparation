package com.priyakdey;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if (level >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        return res;
    }

    private record Pair(TreeNode node, int level) {
    }

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

}
