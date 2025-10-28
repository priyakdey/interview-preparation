package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0281 {

    private final int[] values;
    private int cursor;

    public P0281(List<Integer> v1, List<Integer> v2) {
        int length = v1.size() + v2.size();
        this.values = new int[length];

        int i = 0, j = 0, k = 0;
        while (i < v1.size() && j < v2.size()) {
            values[k++] = v1.get(i++);
            values[k++] = v2.get(j++);
        }

        while (i < v1.size()) values[k++] = v1.get(i++);
        while (j < v2.size()) values[k++] = v2.get(j++);
    }

    public int next() {
        return values[cursor++];
    }

    public boolean hasNext() {
        return cursor < values.length;
    }

}
