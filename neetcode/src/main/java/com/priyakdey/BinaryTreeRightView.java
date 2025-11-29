package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class BinaryTreeRightView {

    // Do a level traversal, using a queue. For each level, just
    // consider the first element which enters the queue.

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if (result.size() == level) {
                result.add(node.val);
            }
            
            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
            
            if (node.left != null) {
                queue.offer(new Pair(node.left, level + 1));
            }
        }

        return result;
    }

    private record Pair(TreeNode node, int level) {
    }

}
