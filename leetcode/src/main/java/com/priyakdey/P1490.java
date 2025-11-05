package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P1490 {

    public Node cloneTree(Node root) {
        if (root == null) return null;

        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node clonedNode = map.get(node);

            for (Node child : node.children) {
                Node clonedChild = new Node(child.val);
                map.put(child, clonedChild);
                clonedNode.children.add(clonedChild);
                queue.offer(child);
            }

        }

        return map.get(root);
    }

    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
