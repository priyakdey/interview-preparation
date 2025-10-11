package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append('-');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int curr = 0;
        int length = str.length();

        while (curr < length) {
            // parse the number
            int lengthStart = curr;
            while (curr < length && str.charAt(curr) != '-') {
                curr++;
            }
            int n = Integer.parseInt(str.substring(lengthStart, curr));

            int wordStart = curr + 1;
            curr = wordStart + n;

            result.add(str.substring(wordStart, curr));
        }

        return result;
    }

    public static void main(String[] args) {
        var e = new EncodeAndDecodeStrings();

        System.out.println(e.decode(e.encode(List.of("4neet", "-code", "lo-ve", "you"))));

    }

}
