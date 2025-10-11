package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class BinaryTreeCodec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return String.valueOf(root.val);

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nullCount = 0;

        List<String> buffer = new ArrayList<>();

        while (!queue.isEmpty() && nullCount != queue.size()) {
            TreeNode node = queue.poll();

            if (node == null) {
                buffer.add("");
                nullCount--;
            } else {
                buffer.add(String.valueOf(node.val));

                queue.offer(node.left);
                queue.offer(node.right);
                if (node.left == null) nullCount++;
                if (node.right == null) nullCount++;
            }
        }

        return String.join(",", buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        int length = nodes.length;
        if (length == 1) return root;

        int cursor = 1;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (cursor < length) {
            TreeNode node = Objects.requireNonNull(queue.poll());

            String leftVal = nodes[cursor];
            if (!Objects.equals(leftVal, "")) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
            }

            if (cursor + 1 >= length) {
                break;
            }

            String rightVal = nodes[cursor];
            if (!Objects.equals(rightVal, "")) {
                node.left = new TreeNode(Integer.parseInt(rightVal));
            }
            cursor += 2;
        }

        return root;
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
