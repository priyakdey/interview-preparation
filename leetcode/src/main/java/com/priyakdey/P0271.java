package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0271 {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append('-');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        int length = s.length();
        int curr = 0;
        List<String> list = new ArrayList<>();

        while (curr < length) {
            int start = curr;
            while (curr < length && s.charAt(curr) != '-') {
                curr++;
            }

            try {
                int substringLength = Integer.parseInt(s.substring(start, curr));
                curr++;     // skip the delimiter
                if (curr + substringLength > length) {
                    throw new IllegalArgumentException("invalid input");
                }

                String substring = s.substring(curr, curr + substringLength);
                list.add(substring);
                curr += substringLength;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid input");
            }
        }

        return list;
    }

}
