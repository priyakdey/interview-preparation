package com.priyakdey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class TimeMap {

    private final Map<String, List<Value>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Value(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Value> values = map.get(key);

        String value = "";

        int left = 0, right = values.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Value v = values.get(mid);
            if (v.timestamp <= timestamp) {
                value = v.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return value;
    }

    private record Value(String value, int timestamp) {
    }

}
