package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class P1087 {

    public String[] expand(String s) {
        List<String> acc = new ArrayList<String>();
        expand(s, 0, new StringBuilder(), acc);
        return acc.toArray(new String[0]);
    }

    private void expand(String s, int index, StringBuilder sb, List<String> acc) {
        if (index == s.length()) {
            acc.add(sb.toString());
            return;
        }

        char ch = s.charAt(index);
        if (ch != '{') {
            sb.append(ch);
            expand(s, index + 1, sb, acc);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        // parse till we find the closing pair
        int start = index + 1;
        while (index < s.length() && s.charAt(index) != '}') {
            index++;
        }

        int bitmap = 0;

        // parse the character options
        for (int i = start; i < index; i = i + 2) {
            char c = s.charAt(i);
            int j = c - 'a';
            bitmap = (bitmap | (1 << j));
        }

        for (int i = 0; i < 32; i++) {
            if (((bitmap >>> i) & 1) == 1) {
                char c = (char) (i + 'a');
                sb.append(c);
                expand(s, index + 1, sb, acc);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
