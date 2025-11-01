package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class P0422 {

    public boolean validWordSquare(List<String> words) {
        int length = words.size();

        for (int k = 0; k < length; k++) {
            String word = words.get(k);
            for (int i = 0; i < word.length(); i++) {
                if (i >= words.size() || k >= words.get(i).length()
                        || words.get(i).charAt(k) != word.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

}
