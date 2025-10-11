package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = generateGraph(prerequisites);
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;

            if (!graph.containsKey(course)) {
                continue;
            }

            for (Integer u : graph.get(course)) {
                indegree[u]--;
                if (indegree[u] == 0) {
                    queue.offer(u);
                }
            }
        }

        return numCourses == 0;
    }

    private Map<Integer, List<Integer>> generateGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new ArrayList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return graph;
    }

}
