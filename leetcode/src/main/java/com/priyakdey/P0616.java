package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class P0616 {


    public String addBoldTag(String s, String[] words) {
        List<int[]> ranges = new ArrayList<>();
        for (String word : words) {
            ranges.addAll(findRange(s, word));
        }

        if (ranges.isEmpty()) {
            return s;
        }

        Collections.sort(ranges, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparing((int[] a) -> a[1]));

        List<int[]> mergedRanges = new ArrayList<>();
        mergedRanges.add(ranges.getFirst());

        for (int i = 1; i < ranges.size(); i++) {
            int prevEnd = mergedRanges.getLast()[1];

            int currStart = ranges.get(i)[0];
            int currEnd = ranges.get(i)[1];

            if (currStart <= prevEnd) {
                mergedRanges.getLast()[1] = Math.max(prevEnd, currEnd);
            } else {
                mergedRanges.add(new int[]{currStart, currEnd});
            }
        }

        return getStringBuilder(s, mergedRanges);
    }

    private String getStringBuilder(String s, List<int[]> mergedRanges) {
        StringBuilder sb = new StringBuilder();
        int cursor = 0;
        int i = 0;
        while (i < s.length()) {
            if (cursor < mergedRanges.size() && i == mergedRanges.get(cursor)[0]) {
                int start = mergedRanges.get(cursor)[0];
                int end = mergedRanges.get(cursor)[1];
                sb.append("<b>");
                sb.append(s, start, end);
                sb.append("</b>");
                cursor++;
                i += end - start;
            } else {
                sb.append(s.charAt(i++));
            }
        }

        return sb.toString();
    }

    private List<int[]> findRange(String s, String word) {
        int wordLength = word.length();
        int sLength = s.length();

        List<int[]> ranges = new ArrayList<>();

        for (int start = 0; start < sLength - wordLength + 1; start++) {
            int end = start + wordLength;
            if (Objects.equals(s.substring(start, end), word)) {
                ranges.add(new int[]{start, end});
            }
        }

        return ranges;
    }

}
