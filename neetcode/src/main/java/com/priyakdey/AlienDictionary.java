package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class AlienDictionary {

    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = generateGraph(words);
        Map<Character, Integer> indegree = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            Character key = entry.getKey();
            indegree.put(key, 0);

            for (Character c : entry.getValue()) {
                indegree.put(c, indegree.compute(c,
                        (k, v) -> v == null ? 0 : v + 1));
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 0) {
                queue.offer(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            sb.append(ch);

            for (Character c : graph.get(ch)) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }

        return sb.toString();
    }

    private Map<Character, Set<Character>> generateGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            for (int i = 1; i < word.length(); i++) {
                char from = word.charAt(i - 1);
                char to = word.charAt(i);
                if (to != from) {
                    graph.computeIfAbsent(from, (k) -> new HashSet<>()).add(to);
                }
            }
        }

        return graph;
    }

}
