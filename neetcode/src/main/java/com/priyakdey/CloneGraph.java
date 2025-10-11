package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> map) {
        Node clonedNode = map.computeIfAbsent(node, k -> new Node(node.val));

        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, cloneGraph(neighbor, map));
            }

            Node clonedNeighbor = map.get(neighbor);
            clonedNode.neighbors.add(clonedNeighbor);
        }

        return clonedNode;
    }

}
