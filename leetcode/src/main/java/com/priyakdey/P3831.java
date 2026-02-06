package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P3831 {

    public int levelMedian(TreeNode root, int level) {
        List<Integer> buffer = new ArrayList<>();
        traverse(root, level, 0, buffer);

        int length = buffer.size();
        if (length == 0) return -1;
        int mid = length / 2;
        return buffer.get(mid);
    }

    private void traverse(TreeNode node, int level, int currLevel, List<Integer> buffer) {
        if (node == null) return;

        if (currLevel == level) {
            buffer.add(node.val);
            return;
        }

        traverse(node.left, level, currLevel + 1, buffer);
        traverse(node.right, level, currLevel + 1, buffer);
    }

}
