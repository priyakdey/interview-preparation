package com.priyakdey;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = generateGraph(n, edges);
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new LinkedList<>();
        int components = 0;

        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;

            components++;
            stack.add(node);
            visited[node] = true;

            while (!stack.isEmpty()) {
                int u = stack.pop();
                for (int v : graph.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        stack.add(v);
                    }
                }
            }
        }

        return components;
    }

    private List<List<Integer>> generateGraph(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            int u =  edge[0];
            int v =  edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

}
