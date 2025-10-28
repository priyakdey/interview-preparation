package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = generateGraph(n, times);
        int[] delays = new int[n];
        Arrays.fill(delays, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::edge));

        delays[k - 1] = 0;
        pq.offer(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int vertex = pair.vertex;

            int currDelay = pair.edge;

            for (Pair p : graph.get(vertex)) {
                if (delays[p.vertex] == -1 || currDelay + p.edge < delays[p.vertex]) {
                    delays[p.vertex] = currDelay + p.edge;
                    pq.offer(new Pair(p.vertex, currDelay + p.edge));
                }
            }
        }

        int minDelay = -1;

        for (int delay : delays) {
            if (delay == -1) {
                return -1;
            }
            if (minDelay == -1 || minDelay < delay) {
                minDelay = delay;
            }
        }

        return minDelay;
    }

    private List<List<Pair>> generateGraph(int n, int[][] times) {
        List<List<Pair>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int src = time[0] - 1;
            int dst = time[1] - 1;
            int wt = time[2];
            graph.get(src).add(new Pair(dst, wt));
        }

        return graph;
    }

    private record Pair(int vertex, int edge) {
    }

}
