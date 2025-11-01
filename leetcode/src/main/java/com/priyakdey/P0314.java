package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int mid = 0;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int offset = pair.offset;

            if (offset == 0) {
                res.get(mid).add(node.val);
            } else if (offset < 0) {
                if (mid + offset < 0) {
                    res.addFirst(new ArrayList<>());
                    mid++;
                }
                res.get(mid + offset).add(node.val);
            } else {
                if (offset + mid >= res.size()) {
                    res.add(new ArrayList<>());
                }
                res.get(offset + mid).add(node.val);
            }


            if (node.left != null) {
                queue.offer(new Pair(node.left, offset - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, offset + 1));
            }

        }

        return res;
    }

    private record Pair(TreeNode node, int offset) {
    }

    private static class TreeNode {
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
